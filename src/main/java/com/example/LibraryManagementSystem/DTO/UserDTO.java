package com.example.LibraryManagementSystem.DTO;

import com.example.LibraryManagementSystem.Model.User;

public class UserDTO {
    private long user_id;

    private String user_type;

    private int card_no;

    private String reputation;

    public UserDTO(User user) {
        this.user_id = user.getUserId();
        this.user_type = user.getUserType();
        this.card_no = user.getCardNo();
        this.reputation = user.getReputation();
    }

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long userId) {
        this.user_id = userId;
    }

    public String getUserType() {
        return user_type;
    }

    public void setUserType(String userType) {
        this.user_type = userType;
    }

    public int getCardNo() {
        return card_no;
    }

    public void setCardNo(int cardNo) {
        this.card_no = cardNo;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }
}
