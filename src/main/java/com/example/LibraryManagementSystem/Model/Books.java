package com.example.LibraryManagementSystem.Model;

import javax.persistence.*;

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


    public Books() {
        super();
    }

    public long getBookId() {
        return book_id;
    }

    public void setBookId(long bookId) {
        this.book_id = bookId;
    }

    public String getBookType() {
        return book_type;
    }

    public void setBookType(String bookType) {
        this.book_type = bookType;
    }

    public Books(long bookId, String bookType) {
        this.book_id = bookId;
        this.book_type = bookType;
    }

}
