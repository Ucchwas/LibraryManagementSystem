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
public class Books {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_id_seq")
    @SequenceGenerator(name = "books_id_seq", sequenceName = "books_id_seq", allocationSize = 1)
    public long book_id;

    @Column(name = "book_type")
    public String book_type;

    @OneToOne
    @JoinColumn(name = "librarybooks_id")
    private LibraryBooks listOfBooks;

    public Books(long book_id, String book_type) {
        this.book_id  = book_id;
        this.book_type = book_type;
    }
}
