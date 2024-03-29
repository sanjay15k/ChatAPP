package com.nsit.chatapp.DTO;

import java.io.Serializable;

public class ChatsDTO implements Serializable {

    private String profileImageURL;
    private String username;
    private String recentMessage;
    private String recentTime;
    private String phoneNumber;
    private String uid;

//    public ChatsDTO(String profileImageURL, String username, String recentMessage, String recentTime, String phoneNumber) {
//        this.profileImageURL = profileImageURL;
//        this.username = username;
//        this.recentMessage = recentMessage;
//        this.recentTime = recentTime;
//        this.phoneNumber = phoneNumber;
//    }

    public String getProfileImageURL() {
        return profileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRecentMessage() {
        return recentMessage;
    }

    public void setRecentMessage(String recentMessage) {
        this.recentMessage = recentMessage;
    }

    public String getRecentTime() {
        return recentTime;
    }

    public void setRecentTime(String recentTime) {
        this.recentTime = recentTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
