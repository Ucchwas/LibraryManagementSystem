package com.example.LibraryManagementSystem.Model;

import javax.persistence.*;

@Entity
@Table
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long bookId;

    @Column
    public String bookType;

    @OneToOne
    private Feedback feedback;

    public Books() {
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Books(long bookId, String bookType) {
        this.bookId = bookId;
        this.bookType = bookType;
    }

}
