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
package com.livgrhm.kansas.core;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author oliviagraham
 */
public class Milestone {
    private int milestoneId;
    private int goalId;
    private String milestoneText;
    private int milestoneDuration;
    private Date milestoneStartDate;
    private Date milestoneEndDate;
    private int isActive;
    private int isDeleted;
    private Timestamp datetimeCreated;
    private Timestamp datetimeUpdate;
    
    public Milestone() { }
    
    public Milestone (int milestoneId, int goalId, String milestoneText, Time milestoneTime,
            int milestoneDuration, Date milestoneStartDate, Date milestoneEndDate, int isActive,
            int isDeleted, Timestamp datetimeCreated, Timestamp datetimeUpdated) {
        
        this.milestoneId = milestoneId;
        this.goalId = goalId;
        this.milestoneText = milestoneText;
        this.milestoneDuration = milestoneDuration;
        this.milestoneStartDate = milestoneStartDate;
        this.milestoneEndDate = milestoneEndDate;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.datetimeCreated = datetimeCreated;
        this.datetimeCreated = datetimeUpdated;
    }

    /**
     * @return the milestoneId
     */
    public int getMilestoneId() {
        return milestoneId;
    }

    /**
     * @param milestoneId the milestoneId to set
     */
    public void setMilestoneId(int milestoneId) {
        this.milestoneId = milestoneId;
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
     * @return the milestoneText
     */
    public String getMilestoneText() {
        return milestoneText;
    }

    /**
     * @param milestoneText the milestoneText to set
     */
    public void setMilestoneText(String milestoneText) {
        this.milestoneText = milestoneText;
    }

    /**
     * @return the milestoneDuration
     */
    public int getMilestoneDuration() {
        return milestoneDuration;
    }

    /**
     * @param milestoneDuration the milestoneDuration to set
     */
    public void setMilestoneDuration(int milestoneDuration) {
        this.milestoneDuration = milestoneDuration;
    }

    /**
     * @return the milestoneStartDate
     */
    public Date getMilestoneStartDate() {
        return milestoneStartDate;
    }

    /**
     * @param milestoneStartDate the milestoneStartDate to set
     */
    public void setMilestoneStartDate(Date milestoneStartDate) {
        this.milestoneStartDate = milestoneStartDate;
    }

    /**
     * @return the milestoneEndDate
     */
    public Date getMilestoneEndDate() {
        return milestoneEndDate;
    }

    /**
     * @param milestoneEndDate the milestoneEndDate to set
     */
    public void setMilestoneEndDate(Date milestoneEndDate) {
        this.milestoneEndDate = milestoneEndDate;
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
     * @return the datetimeUpdate
     */
    public Timestamp getDatetimeUpdate() {
        return datetimeUpdate;
    }

    /**
     * @param datetimeUpdate the datetimeUpdate to set
     */
    public void setDatetimeUpdate(Timestamp datetimeUpdate) {
        this.datetimeUpdate = datetimeUpdate;
    }
        
}
