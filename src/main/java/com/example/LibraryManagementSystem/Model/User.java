package com.example.LibraryManagementSystem.Model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private long user_id;

    @Column
    private String user_type;

    @Column
    private int card_no;

    @Column
    private String reputation;


    public User(long userId,String userType,int cardNo,String reputation) {
        this.user_id = userId;
        this.user_type = userType;
        this.card_no = cardNo;
        this.reputation = reputation;
    }

    public User() {
        super();
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
