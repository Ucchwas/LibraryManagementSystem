package com.example.LibraryManagementSystem.Model;

import javax.persistence.*;

@Entity
@Table
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_id_seq")
    @SequenceGenerator(name = "feedback_id_seq", sequenceName = "feedback_id_seq", allocationSize = 1)
    public long user_id;

    @Column
    public long book_id;

    @Column
    private Long rating;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false , insertable=false , updatable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "books_id", nullable = false , insertable=false , updatable=false)
    private Books books;

    public Feedback(long userId,long bookId,Long rating) {
        this.user_id = userId;
        this.book_id = bookId;
        this.rating = rating;
    }

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long userId) {
        this.user_id = userId;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "user_id=" + user_id +
                ", book_id=" + book_id +
                ", rating=" + rating +
                ", user=" + user +
                ", books=" + books +
                '}';
    }

    public long getBookId() {
        return book_id;
    }

    public void setBookId(long bookId) {
        this.book_id = bookId;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Feedback() {
        super();
    }
}
