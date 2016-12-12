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
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName; 
    @JsonProperty("email")
    private String email;
    @JsonProperty("userPasswordHash")
    private String userPasswordHash; 
    @JsonProperty("userStatus")
    private String userStatus;
    @JsonProperty("userAuthHash")
    private String userAuthHash; 
    @JsonProperty("userLastIP")
    private String userLastIP; 
    @JsonProperty("userFailedLogons")
    private int userFailedLogons;
    @JsonProperty("userAuthTimestamp")
    private Date userAuthTimestamp;
    @JsonProperty("isActive")
    private int isActive;
    @JsonProperty("isDeleted")
    private int isDeleted;
    @JsonProperty("datetimeCreated")
    private Timestamp datetimeCreated;
    @JsonProperty("datetimeUpdated")
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
     * @return the userFailedLogons
     */
    public int getUserFailedLogons() {
        return userFailedLogons;
    }

    /**
     * @param userFailedLogons the userFailedLogons to set
     */
    public void setUserFailedLogons(int userFailedLogons) {
        this.userFailedLogons = userFailedLogons;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the userPasswordHash
     */
    public String getUserPasswordHash() {
        return userPasswordHash;
    }

    /**
     * @param userPasswordHash the userPasswordHash to set
     */
    public void setUserPasswordHash(String userPasswordHash) {
        this.userPasswordHash = userPasswordHash;
    }

    /**
     * @return the userAuthHash
     */
    public String getUserAuthHash() {
        return userAuthHash;
    }

    /**
     * @param userAuthHash the userAuthHash to set
     */
    public void setUserAuthHash(String userAuthHash) {
        this.userAuthHash = userAuthHash;
    }

    /**
     * @return the userLastIP
     */
    public String getUserLastIP() {
        return userLastIP;
    }

    /**
     * @param userLastIP the userLastIP to set
     */
    public void setUserLastIP(String userLastIP) {
        this.userLastIP = userLastIP;
    }

    /**
     * @return the userStatus
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus the userStatus to set
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * @return the userAuthTimestamp
     */
    public Date getUserAuthTimestamp() {
        return userAuthTimestamp;
    }

    /**
     * @param userAuthTimestamp the userAuthTimestamp to set
     */
    public void setUserAuthTimestamp(Date userAuthTimestamp) {
        this.userAuthTimestamp = userAuthTimestamp;
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
