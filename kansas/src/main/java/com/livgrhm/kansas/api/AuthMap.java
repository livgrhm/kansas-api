/*
 * The MIT License
 *
 * Copyright 2017 oliviagraham.
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
package com.livgrhm.kansas.api;

import com.livgrhm.kansas.core.User;
import com.livgrhm.kansas.db.UserDAO;
import java.util.HashMap;
import org.apache.commons.lang.time.DateUtils;

/**
 *
 * @author oliviagraham
 */
public class AuthMap {
    private final UserDAO dao;
    private AuthItem thisAuth;
    
    private HashMap authMap = new HashMap();
    
    public AuthMap (UserDAO dao) {
        this.dao = dao;
    }
    
    public HashMap getAuthMap() {
        return this.authMap;
    }
    
    public void setAuthMap(HashMap authMap) {
        this.authMap = authMap;
    }
    
    public boolean isAuthorised(String hash, String ip) {
        System.out.println("AUTHORISING: " + hash + " IP: " + ip);
        
        if (hash == null || hash.equals("")) {
            return false;
        }

        this.thisAuth = (AuthItem) this.authMap.get(hash);

        // current expiration time set as 8 hours
        DateUtils du = new DateUtils();
        java.sql.Date testDate = new java.sql.Date((new java.util.Date()).getTime());

        if (this.thisAuth != null) {
            if (!this.thisAuth.loginDate.toString().equals(testDate.toString()) || !this.thisAuth.ipAddress.equals(ip)) {
                // session expired - so return false, and delete this entry
                authMap.remove(hash);
                return false;
            }
            return true;    // i.e. the hash exists, and is current!
        }

        // hash is not in the list, but could be in the database (i.e. logged on from another instance of the server, or server could have
        // been bounced. So see if it is in the db
        User user = this.dao.getUserByCurrentHash(hash);
        if (user == null) {
            return false;   // hash doesn't exist
        }
        if (!user.getUserAuthTimestamp().toString().equals(testDate.toString())) {
            return false;   // hash is in the db, but has expired
        }
        if (!user.getUserLastIP().equals(ip)) {
            return false;   // hash is in the db, but wrong IP address
        }

        // so has exists and is still current - update thisAuth (i.e. for the current request), and update the hash table and return true
        AuthItem ai = new AuthItem();
        ai.userId = user.getUserId();
        ai.loginDate = user.getUserAuthTimestamp();
        ai.ipAddress = ip;
        authMap.put(hash, ai);
        thisAuth = ai;
        return true;
    }
}
