package com.example.LibraryManagementSystem.Model;

import javax.persistence.*;

@Entity
@Table
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long bookId;

    @Column
    private String feedback;


    public Feedback(long bookId,String feedback) {
        this.bookId = bookId;
        this.feedback = feedback;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Feedback() {
    }
}
