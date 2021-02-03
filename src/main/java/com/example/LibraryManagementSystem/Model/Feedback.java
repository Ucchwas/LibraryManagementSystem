package com.example.LibraryManagementSystem.Model;

import javax.persistence.*;

@Entity
@Table
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long userId;

    @Column
    public long bookId;

    @Column
    private Long rating;

//    @ManyToOne
//    private Books books;
//
//    @ManyToOne
//    private User user;

    public Feedback(long userId,long bookId,Long rating) {
        this.userId = userId;
        this.bookId = bookId;
        this.rating = rating;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Feedback() {
    }
}
