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
import com.livgrhm.kansas.api.SimpleResponse;
import com.livgrhm.kansas.core.User;
import com.livgrhm.kansas.db.UserDAO;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    
    private final UserDAO dao;
    private final HashMap authMap;
    
    private AuthItem thisAuth;

    public UserResource(UserDAO dao, HashMap authMap) {
        this.dao = dao; 
        this.authMap = authMap;
    }
    
    @GET
    @Timed
    public Response getUser(@QueryParam("auth") String auth, @Context HttpServletRequest req) {
        if (!isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("getUser Unauthorised " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        try {
             List<User> list = this.dao.getUsers();
            if (list.size() > 0) {
                return Response.ok(list).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            System.out.println("Exception getting all users: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/{userId}")
    @Timed
    public Response getUserById(@PathParam("userId") int userId, @QueryParam("auth") String auth, @Context HttpServletRequest req) {
        if (!isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("getUserById Unauthorised " + userId + " " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        try {
            User u = this.dao.getUserById(userId);
            if (u != null) {
                return Response.ok(u).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            System.out.println("Exception getting user by ID: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GET
    @Path("email/{email}")
    @Timed 
    public Response getUserByEmail(@PathParam("email") String email, @QueryParam("auth") String auth, @Context HttpServletRequest req) {
        if (!isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("getUserByEmail Unauthorised " + email + " " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        try {
            User u = this.dao.getUserByEmail(email);
            if (u != null) {
                return Response.ok(u).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            System.out.println("Exception getting user by email: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @POST
    @Timed
    public Response addUser(User user, @QueryParam("auth") String auth, @Context HttpServletRequest req) {
        if (!isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("addUser Unauthorised " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        // POST e.g. '{"firstName":"test", "lastName":"tester", "email":"test", "userStatus":"N", "userPasswordHash":"1234"}'
        // Create authentication hash
        java.sql.Date now = new java.sql.Date((new java.util.Date()).getTime());
        String userAuthHash = DigestUtils.sha256Hex(user.getUserPasswordHash() + now.getTime());
        user.setUserAuthHash(userAuthHash);
        user.setUserAuthTimestamp(now);
        
        try {
            int userId = this.dao.createUser(user.getFirstName(), user.getLastName(), 
                    user.getEmail(), user.getUserStatus(), user.getUserPasswordHash(), 
                    user.getUserAuthHash(), user.getUserAuthTimestamp());
            user.setUserId(userId);
            return Response.status(Response.Status.CREATED).entity(user).build();
        } catch (Exception e) {
            System.out.println("Exception creating user: " + e.getMessage());
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
        }
    }
    
    @PUT
    @Path("/{userId}")
    @Timed
    public Response updateUser(@PathParam("userId") int userId, User user, @QueryParam("auth") String auth, @Context HttpServletRequest req) {
        if (!isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("updateUser Unauthorised " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        // PUT e.g. '{"firstName":"test", "lastName":"tester", "email":"test"}'
        try {
            this.dao.updateUser(userId, user.getFirstName(), user.getLastName(), user.getEmail());
            return Response.status(Response.Status.OK).entity(user).build();
        } catch (Exception e) {
            System.out.println("Exception updating user: " + e.getMessage());
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
        }
    }
    
    @DELETE
    @Path("/{userId}")
    @Timed
    public Response deleteUser(@PathParam("userId") int userId, @QueryParam("auth") String auth, @Context HttpServletRequest req) {
        if (!isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("deleteUser Unauthorised " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        try {
            this.dao.deleteUser(userId);
            // create an ok response object
            SimpleResponse resp = new SimpleResponse(200, "OK", "User successfully deleted.");
            return Response.status(Response.Status.OK).entity(resp).build();
        } catch (Exception e) {
            System.out.println("Exception deleting user: " + e.getMessage());
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
        }
    }
    
    private boolean isAuthorised(String hash, String ip) {
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