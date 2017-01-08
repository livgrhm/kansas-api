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
import com.livgrhm.kansas.api.AuthMap;
import com.livgrhm.kansas.api.SimpleResponse;
import com.livgrhm.kansas.core.Goal;
import com.livgrhm.kansas.db.GoalDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author oliviagraham
 */
@Path("/goal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GoalResource {
    
    private final GoalDAO dao;
    private final AuthMap authMap;

    public GoalResource(GoalDAO dao, AuthMap authMap) {
        this.dao = dao; 
        this.authMap = authMap;
    }
    
    @GET
    @Timed
    public Response getGoals(@QueryParam("auth") String auth, @Context HttpServletRequest req) {
        // + need to check user roles = admin
        if (!authMap.isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("getGoals Unauthorised " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        try {
            List<Goal> list = this.dao.getGoals();
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
    @Path("/{goalId}")
    @Timed
    public Response getGoal(@PathParam("goalId") int goalId, @QueryParam("auth") String auth, @Context HttpServletRequest req) {
        if (!authMap.isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("getGoal Unauthorised " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        try {
            Goal g = this.dao.getGoalById(goalId);
            if (g != null) {
                g.setGoalSteps(this.dao.getGoalSteps(g.getGoalId()));
                return Response.ok(g).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            System.out.println("Exception getting goal: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GET
    @Path("user/{userId}")
    @Timed
    public Response getUserGoals(@PathParam("userId") int userId, @QueryParam("auth") String auth, @Context HttpServletRequest req) {
        if (!authMap.isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("getUserGoals Unauthorised " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        try {
            List<Goal> list = this.dao.getGoalsByUserId(userId);
            if (list != null) {
                return Response.ok(list).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            System.out.println("Exception getting goal: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @POST
    @Timed
    public Response addGoal(Goal goal, @QueryParam("auth") String auth, @Context HttpServletRequest req) {
        // POST:{"userId":"9","timespan":"2","goalContent":"Test Create Goal"}
        if (!authMap.isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("addGoal Unauthorised " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        try {
            int goalId = this.dao.createGoal(goal.getUserId(), goal.getTimespan(), goal.getGoalContent());
            goal.setGoalId(goalId);
            return Response.status(Response.Status.CREATED).entity(goal).build();
        } catch (Exception e) {
            System.out.println("Exception creating goal: " + e.getMessage());
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
        }
    }
        
    @PUT
    @Timed
    public Response updateGoal(Goal goal, @QueryParam("auth") String auth, @Context HttpServletRequest req) {
        // PUT:{"goalId":"1","timespan":"2","goalContent":"Test Create Goal"}
        if (!authMap.isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("updateGoal Unauthorised " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        try {
            this.dao.updateGoal(goal.getGoalId(), goal.getTimespan(), goal.getGoalContent());
            return Response.status(Response.Status.OK).entity(goal).build();
        } catch (Exception e) {
            System.out.println("Exception updating goal: " + e.getMessage());
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
        }
    }
    
    @DELETE
    @Path("/{goalId}")
    @Timed
    public Response deleteGoal(@PathParam("goalId") int goalId, @QueryParam("auth") String auth, @Context HttpServletRequest req) {
        if (!authMap.isAuthorised(auth, req.getRemoteAddr())) {
            System.out.println("deleteGoal Unauthorised " + auth);
            SimpleResponse resp = new SimpleResponse(401, "Unauthorized", "Authorization is required.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(resp).build();
        }
        try {
            this.dao.deleteGoal(goalId);
            SimpleResponse resp = new SimpleResponse(200, "OK", "Goal successfully deleted.");
            return Response.status(Response.Status.OK).entity(resp).build();
        } catch (Exception e) {
            System.out.println("Exception deleting goal: " + e.getMessage());
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
        }
    }
}
