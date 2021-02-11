package com.example.LibraryManagementSystem.DTO;

import com.example.LibraryManagementSystem.Model.LibraryBooks;

public class LibraryBooksDTO {
    private long id;

    private long book_id;

    private long library_id;

    public LibraryBooksDTO(LibraryBooks libraryBooks) {
        this.id = libraryBooks.getId();
        this.book_id = libraryBooks.getBookId();
        this.library_id = libraryBooks.getLibraryId();
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
}
