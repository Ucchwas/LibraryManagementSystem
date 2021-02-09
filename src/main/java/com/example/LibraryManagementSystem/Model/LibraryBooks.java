package com.example.LibraryManagementSystem.Model;

import com.example.LibraryManagementSystem.Model.Library;

import javax.persistence.*;

@Entity
@Table
public class LibraryBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "librarybooks_id_seq")
    @SequenceGenerator(name = "librarybooks_id_seq", sequenceName = "librarybooks_id_seq", allocationSize = 1)
    private long id;

    @Column
    private long book_id;

    @Column
    private long library_id;

    @ManyToOne
    @JoinColumn(name = "library_id", nullable = false , insertable=false , updatable=false)
    private Library library;

    public LibraryBooks(long id,long bookId,long libraryId){
        this.id = id;
        this.book_id = bookId;
        this.library_id = libraryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return book_id;
    }

    public void setBookId(long bookId) {
        this.book_id = bookId;
    }

    public long getLibraryId() {
        return library_id;
    }

    public void setLibraryId(long libraryId) {
        this.library_id = libraryId;
    }

    public LibraryBooks() {
        super();
    }


}
