package com.example.LibraryManagementSystem.Model;

public class Member implements User {
    private int userId;
    private String userType;
    private int cardNo;
    private String reputation;
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
    public void setCardNo(int no){
        this.cardNo = no;
    }
    public int getCardNo(){
        return cardNo;
    }
    public void setReputation(String reputation){
        this.reputation = reputation;
    }
    public String getReputation(){
        return reputation;
    }
}
