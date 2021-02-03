package com.example.LibraryManagementSystem.Model;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column
    private String userType;

    @Column
    private int cardNo;

    @Column
    private String reputation;


    public User(long userId,String userType,int cardNo,String reputation) {
        this.userId = userId;
        this.userType = userType;
        this.cardNo = cardNo;
        this.reputation = reputation;
    }

    public User() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

}
