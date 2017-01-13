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
package com.livgrhm.kansas.core;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author oliviagraham
 */
public class Goal {
    // core
    private int goalId;
    private int userId;
    private int timespan;
    private String goalContent;
    private int isActive;
    private int isDeleted;
    private Timestamp datetimeCreated;
    private Timestamp datetimeUpdated;
    
    // helpers
    private List<GoalStep> goalSteps;
    private List<Milestone> milestones;
    private List<Habit> habits;
    
    public Goal () { }
    
    public Goal (int goalId, int userId, int timespan, String goalContent, int isActive,
            int isDeleted, Timestamp datetimeCreated, Timestamp datetimeUpdated) {
        
        this.goalId = goalId;
        this.userId = userId;
        this.timespan = timespan;
        this.goalContent = goalContent;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.datetimeCreated = datetimeCreated;
        this.datetimeUpdated = datetimeUpdated;
    }

    /**
     * @return the goalId
     */
    public int getGoalId() {
        return goalId;
    }

    /**
     * @param goalId the goalId to set
     */
    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the timespan
     */
    public int getTimespan() {
        return timespan;
    }

    /**
     * @param timespan the timespan to set
     */
    public void setTimespan(int timespan) {
        this.timespan = timespan;
    }

    /**
     * @return the goalContent
     */
    public String getGoalContent() {
        return goalContent;
    }

    /**
     * @param goalContent the goalContent to set
     */
    public void setGoalContent(String goalContent) {
        this.goalContent = goalContent;
    }

    /**
     * @return the isActive
     */
    public int getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the isDeleted
     */
    public int getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return the datetimeCreated
     */
    public Timestamp getDatetimeCreated() {
        return datetimeCreated;
    }

    /**
     * @param datetimeCreated the datetimeCreated to set
     */
    public void setDatetimeCreated(Timestamp datetimeCreated) {
        this.datetimeCreated = datetimeCreated;
    }

    /**
     * @return the datetimeUpdated
     */
    public Timestamp getDatetimeUpdated() {
        return datetimeUpdated;
    }

    /**
     * @param datetimeUpdated the datetimeUpdated to set
     */
    public void setDatetimeUpdated(Timestamp datetimeUpdated) {
        this.datetimeUpdated = datetimeUpdated;
    }

    /**
     * @return the goalSteps
     */
    public List<GoalStep> getGoalSteps() {
        return goalSteps;
    }

    /**
     * @param goalSteps the goalSteps to set
     */
    public void setGoalSteps(List<GoalStep> goalSteps) {
        this.goalSteps = goalSteps;
    }

    /**
     * @return the milestones
     */
    public List<Milestone> getMilestones() {
        return milestones;
    }

    /**
     * @param milestones the milestones to set
     */
    public void setMilestones(List<Milestone> milestones) {
        this.milestones = milestones;
    }

    /**
     * @return the habits
     */
    public List<Habit> getHabits() {
        return habits;
    }

    /**
     * @param habits the habits to set
     */
    public void setHabits(List<Habit> habits) {
        this.habits = habits;
    }
}
