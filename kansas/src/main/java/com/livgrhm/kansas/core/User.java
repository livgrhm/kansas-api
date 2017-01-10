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

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author oliviagraham
 */
public class User {
    private int userId;
    private String firstName;
    private String lastName; 
    private String email;
    private String userPasswordHash; 
    private String userStatus;
    private String userAuthHash; 
    private String userLastIP; 
    private int userFailedLogons;
    private Date userAuthTimestamp;
    private int isActive;
    private int isDeleted;
    private Timestamp datetimeCreated;
    private Timestamp datetimeUpdated;

    public User () { }
    
    public User (int userId, String firstName, String lastName, String email,
            String userStatus, String userPasswordHash, String userAuthHash,
            String userLastIP, Date userAuthTimestamp, int userFailedLogons,
            int isActive, int isDeleted, Timestamp datetimeCreated, Timestamp datetimeUpdated) {
        
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userStatus = userStatus;
        this.userPasswordHash = userPasswordHash;
        this.userAuthHash = userAuthHash;
        this.userLastIP = userLastIP;
        this.userAuthTimestamp = userAuthTimestamp;
        this.userFailedLogons = userFailedLogons;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.datetimeCreated = datetimeCreated;
        this.datetimeCreated = datetimeUpdated;
    }
    
    /**
     * @return the userId
     */
    @JsonProperty
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    @JsonProperty
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the userFailedLogons
     */
    @JsonProperty
    public int getUserFailedLogons() {
        return userFailedLogons;
    }

    /**
     * @param userFailedLogons the userFailedLogons to set
     */
    @JsonProperty
    public void setUserFailedLogons(int userFailedLogons) {
        this.userFailedLogons = userFailedLogons;
    }

    /**
     * @return the firstName
     */
    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    @JsonProperty
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    @JsonProperty
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    @JsonProperty
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    @JsonProperty
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    @JsonProperty
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the userPasswordHash
     */
    @JsonProperty
    public String getUserPasswordHash() {
        return userPasswordHash;
    }

    /**
     * @param userPasswordHash the userPasswordHash to set
     */
    @JsonProperty
    public void setUserPasswordHash(String userPasswordHash) {
        this.userPasswordHash = userPasswordHash;
    }

    /**
     * @return the userAuthHash
     */
    @JsonProperty
    public String getUserAuthHash() {
        return userAuthHash;
    }

    /**
     * @param userAuthHash the userAuthHash to set
     */
    @JsonProperty
    public void setUserAuthHash(String userAuthHash) {
        this.userAuthHash = userAuthHash;
    }

    /**
     * @return the userLastIP
     */
    @JsonProperty
    public String getUserLastIP() {
        return userLastIP;
    }

    /**
     * @param userLastIP the userLastIP to set
     */
    @JsonProperty
    public void setUserLastIP(String userLastIP) {
        this.userLastIP = userLastIP;
    }

    /**
     * @return the userStatus
     */
    @JsonProperty
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus the userStatus to set
     */
    @JsonProperty
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * @return the userAuthTimestamp
     */
    @JsonProperty
    public Date getUserAuthTimestamp() {
        return userAuthTimestamp;
    }

    /**
     * @param userAuthTimestamp the userAuthTimestamp to set
     */
    @JsonProperty
    public void setUserAuthTimestamp(Date userAuthTimestamp) {
        this.userAuthTimestamp = userAuthTimestamp;
    }

    /**
     * @return the isActive
     */
    @JsonProperty
    public int getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    @JsonProperty
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the isDeleted
     */
    @JsonProperty
    public int getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    @JsonProperty
    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return the datetimeCreated
     */
    @JsonProperty
    public Timestamp getDatetimeCreated() {
        return datetimeCreated;
    }

    /**
     * @param datetimeCreated the datetimeCreated to set
     */
    @JsonProperty
    public void setDatetimeCreated(Timestamp datetimeCreated) {
        this.datetimeCreated = datetimeCreated;
    }

    /**
     * @return the datetimeUpdated
     */
    @JsonProperty
    public Timestamp getDatetimeUpdated() {
        return datetimeUpdated;
    }

    /**
     * @param datetimeUpdated the datetimeUpdated to set
     */
    @JsonProperty
    public void setDatetimeUpdated(Timestamp datetimeUpdated) {
        this.datetimeUpdated = datetimeUpdated;
    }
	
}
