package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.Books;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BooksService {
    public List<Books> findAllBooks();

    public Books saveBooks(Books books);

    public ResponseEntity<Books> getBookId(long id);

    public Books putBooks(Books booksDetails);

    public ResponseEntity<Object> delBooks(long id);
}
