package com.example.LibraryManagementSystem.DTO;

import com.example.LibraryManagementSystem.Model.Books;
import com.example.LibraryManagementSystem.Model.LibraryBooks;

public class BooksDTO {
    public long book_id;
    public String book_type;

    public long getBookId() {
        return book_id;
    }

    public void setBookId(long book_id) {
        this.book_id = book_id;
    }

    public String getBookType() {
        return book_type;
    }

    public void setBookType(String book_type) {
        this.book_type = book_type;
    }

    public BooksDTO(Books books) {
        this.book_id = books.getBookId();
        this.book_type = books.getBookType();
    }
}
