package com.example.LibraryManagementSystem.Model;

import javax.persistence.*;

@Entity
@Table
public class LibraryBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private long bookId;

    @Column
    private long libraryId;

//    @ManyToOne
//    private Library library;

    public LibraryBooks(long id,long bookId,long libraryId){
        this.id = id;
        this.bookId = bookId;
        this.libraryId = libraryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(long libraryId) {
        this.libraryId = libraryId;
    }

    public LibraryBooks() {
    }


}
