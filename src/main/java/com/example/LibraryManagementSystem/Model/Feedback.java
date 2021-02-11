package com.example.LibraryManagementSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
