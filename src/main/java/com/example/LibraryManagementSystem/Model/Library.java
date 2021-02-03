package com.example.LibraryManagementSystem.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    public long bookId;

    @Column
    public long userId;


    public Library(long id,String name,long bookId,long userId){
        this.id = id;
        this.name = name;
        this.bookId = bookId;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Library() {
    }
}
