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
public class Habit {
    private int habitId;
    private int goalId;
    private String habitText;
    private String habitType;
    private Time habitTime;
    private int habitDuration;
    private Date habitStartDate;
    private Date habitEndDate;
    private int isActive;
    private int isDeleted;
    private Timestamp datetimeCreated;
    private Timestamp datetimeUpdated;
    
    // helpers
    private String habitTypeDesc;
    
    public Habit () { }
    
    public Habit (int habitId, int goalId, String habitText, String habitType,
            Time habitTime, int habitDuration, Date habitStartDate, Date habitEndDate,
            int isActive, int isDeleted, Timestamp datetimeCreated, Timestamp datetimeUpdated,
            String habitTypeDesc) {
        
        this.habitId = habitId;
        this.goalId = goalId;
        this.habitText = habitText;
        this.habitType = habitType;
        this.habitTime = habitTime;
        this.habitDuration = habitDuration;
        this.habitStartDate = habitStartDate;
        this.habitEndDate = habitEndDate;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.datetimeCreated = datetimeCreated;
        this.datetimeUpdated = datetimeUpdated;
        this.habitTypeDesc = habitTypeDesc;
    }

    Habit(int aInt, int aInt0, String string, int aInt1, int aInt2, Timestamp timestamp, Timestamp timestamp0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the habitId
     */
    public int getHabitId() {
        return habitId;
    }

    /**
     * @param habitId the habitId to set
     */
    public void setHabitId(int habitId) {
        this.habitId = habitId;
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
     * @return the habitText
     */
    public String getHabitText() {
        return habitText;
    }

    /**
     * @param habitText the habitText to set
     */
    public void setHabitText(String habitText) {
        this.habitText = habitText;
    }

    /**
     * @return the habitType
     */
    public String getHabitType() {
        return habitType;
    }

    /**
     * @param habitType the habitType to set
     */
    public void setHabitType(String habitType) {
        this.habitType = habitType;
    }

    /**
     * @return the habitTime
     */
    public Time getHabitTime() {
        return habitTime;
    }

    /**
     * @param habitTime the habitTime to set
     */
    public void setHabitTime(Time habitTime) {
        this.habitTime = habitTime;
    }

    /**
     * @return the habitDuration
     */
    public int getHabitDuration() {
        return habitDuration;
    }

    /**
     * @param habitDuration the habitDuration to set
     */
    public void setHabitDuration(int habitDuration) {
        this.habitDuration = habitDuration;
    }

    /**
     * @return the habitStartDate
     */
    public Date getHabitStartDate() {
        return habitStartDate;
    }

    /**
     * @param habitStartDate the habitStartDate to set
     */
    public void setHabitStartDate(Date habitStartDate) {
        this.habitStartDate = habitStartDate;
    }

    /**
     * @return the habitEndDate
     */
    public Date getHabitEndDate() {
        return habitEndDate;
    }

    /**
     * @param habitEndDate the habitEndDate to set
     */
    public void setHabitEndDate(Date habitEndDate) {
        this.habitEndDate = habitEndDate;
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
     * @return the habitTypeDesc
     */
    public String getHabitTypeDesc() {
        return habitTypeDesc;
    }

    /**
     * @param habitTypeDesc the habitTypeDesc to set
     */
    public void setHabitTypeDesc(String habitTypeDesc) {
        this.habitTypeDesc = habitTypeDesc;
    }
}
