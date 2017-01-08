/*
 * The MIT License
 *
 * Copyright 2016 oliviagraham.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.livgrhm.kansas.resources;

import com.codahale.metrics.annotation.Timed;
import com.livgrhm.kansas.api.AuthItem;
import com.livgrhm.kansas.api.AuthMap;
import com.livgrhm.kansas.api.AuthenticationResult;
import com.livgrhm.kansas.core.User;
import com.livgrhm.kansas.db.UserDAO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {
    
    private final UserDAO dao;
    private final AuthMap authMap;
    private final String systemType;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthResource.class);
    
    public AuthResource(UserDAO dao, AuthMap authMap, String systemType) {
        this.dao = dao;
        this.authMap = authMap;
        this.systemType = systemType;
    }

    @GET
    @Timed
    public AuthenticationResult doAuth(@QueryParam("email") String email, @QueryParam("hash") String hash, @Context HttpServletRequest req) {
        User user = this.dao.getUserByEmail(email);
        
        if (user == null) {
            LOGGER.info(" auth notFound " + email);
            return new AuthenticationResult("F");
        }
        if (user.getUserStatus().equals("D")) {
            LOGGER.info(" auth isDisabled " + email);
            return new AuthenticationResult("F");
        }
        if (user.getUserStatus().equals("N")) {
            if (DigestUtils.sha256Hex((email.toUpperCase() + user.getUserPasswordHash())).equals(hash)) {
                LOGGER.info(" auth new " + email);
                return new AuthenticationResult("N");
            } else {
                LOGGER.info(" auth badPassword " + email);
                return new AuthenticationResult("F");
            }
        }
        if (user.getUserStatus().equals("V")) {
            LOGGER.info(" auth notVerified " + email);
            return new AuthenticationResult("V");
        }
        if (user.getUserPasswordHash().equals(hash)) {
            LOGGER.info(" auth successful " + email);

            // create new hash based on the password and a timestamp, and update the user table accordingly.
            // future data requests will then be tested against this authorisation hash (i.e. an authorisation credential).
            // the timestamp is to ensure existing credentials expire after (CURRENTLY) 24 hrs
            java.sql.Date now = new java.sql.Date((new java.util.Date()).getTime());
            String timestampHash = DigestUtils.sha256Hex(user.getUserPasswordHash() + now.getTime());
            
            this.dao.setUserAuthHash(user.getUserId(), timestampHash, now, req.getRemoteAddr());
            
            addToAuthList(user.getEmail(), timestampHash, now, req.getRemoteAddr());
            
            return new AuthenticationResult("Y", user.getUserId(), timestampHash, user.getUserStatus());
        } else {
            LOGGER.info(" auth badPassword " + email);
            if (user.getUserFailedLogons() > 3) { // already 3 failed attempts, so disable the account
                user.setUserStatus("L");
                this.dao.updateUserLockAccount(user.getUserId());
            }
            this.dao.updateFailedLogonCount(user.getUserId());
            return new AuthenticationResult("F");
        }
    }
    
    private void addToAuthList(String email, String hash, java.sql.Date now, String ip) {
        // clear any hashmap entries for this userId
        HashMap authMapInst = this.authMap.getAuthMap();
        Iterator i = authMapInst.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry item = (Map.Entry) i.next();
            AuthItem ai = (AuthItem) item.getValue();
            if (ai.email.equals(email)) {
                i.remove();
            }
        }
        // now add the new key entry
        AuthItem ai = new AuthItem();
        ai.email = email;
        ai.loginDate = now;
        ai.ipAddress = ip;
        authMapInst.put(hash, ai);
        
        System.out.println("PUT IN AUTHMAP HASH: " + hash);
        System.out.println("AUTHMAP SIZE: " + authMapInst.size());
        
        this.authMap.setAuthMap(authMapInst);
    }
}
