package com.example.LibraryManagementSystem.Model;

public class Admin implements User {
    private int userId;
    private String userType;
    @Override
    public void setUserId(int id) {
        this.userId = id;
    }

    @Override
    public void setUserType(String type) {
        this.userType = type;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public String getUserType() {
        return userType;
    }
}
