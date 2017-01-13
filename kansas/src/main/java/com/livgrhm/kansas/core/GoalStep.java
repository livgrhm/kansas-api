package com.livgrhm.kansas.core;


import java.sql.Timestamp;

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

/**
 *
 * @author oliviagraham
 */
public class GoalStep {
    private int goalStepId;
    private int goalId;
    private String goalStepContent;
    private int isActive;
    private int isDeleted;
    private Timestamp datetimeCreated;
    private Timestamp datetimeUpdated;
    
    public GoalStep () { }
    
    public GoalStep (int goalStepId, int goalId, String goalStepContent, int isActive,
            int isDeleted, Timestamp datetimeCreated, Timestamp datetimeUpdated) {
        
        this.goalStepId = goalStepId;
        this.goalId = goalId;
        this.goalStepContent = goalStepContent;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.datetimeCreated = datetimeCreated;
        this.datetimeUpdated = datetimeUpdated;
    }

    /**
     * @return the goalStepId
     */
    public int getGoalStepId() {
        return goalStepId;
    }

    /**
     * @param goalStepId the goalStepId to set
     */
    public void setGoalStepId(int goalStepId) {
        this.goalStepId = goalStepId;
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
     * @return the goalStepContent
     */
    public String getGoalStepContent() {
        return goalStepContent;
    }

    /**
     * @param goalStepContent the goalStepContent to set
     */
    public void setGoalStepContent(String goalStepContent) {
        this.goalStepContent = goalStepContent;
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
}
