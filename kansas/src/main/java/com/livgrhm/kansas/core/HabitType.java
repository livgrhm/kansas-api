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

import java.sql.Timestamp;

/**
 *
 * @author oliviagraham
 */
public class HabitType {
    private int habitTypeId;
    private String habitType;
    private String habitTypeDesc;
    private int isActive;
    private int isDeleted;
    private Timestamp datetimeCreated;
    private Timestamp datetimeUpdated;
    
    public HabitType () { }
    
    public HabitType (int habitTypeId, String habitType, String habitTypeDesc,
            int isActive, int isDeleted, Timestamp datetimeCreated, Timestamp datetimeUpdated) {
        
        this.habitTypeId = habitTypeId;
        this.habitType = habitType;
        this.habitTypeDesc = habitTypeDesc;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.datetimeCreated = datetimeCreated;
        this.datetimeUpdated = datetimeUpdated;
    }

    /**
     * @return the habitTypeId
     */
    public int getHabitTypeId() {
        return habitTypeId;
    }

    /**
     * @param habitTypeId the habitTypeId to set
     */
    public void setHabitTypeId(int habitTypeId) {
        this.habitTypeId = habitTypeId;
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
