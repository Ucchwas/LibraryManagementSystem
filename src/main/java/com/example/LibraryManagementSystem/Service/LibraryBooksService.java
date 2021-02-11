package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.LibraryBooks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface LibraryBooksService {
    public List<LibraryBooks> findAllBooks();

    public LibraryBooks saveBooks(@RequestBody LibraryBooks listOfBooks);

    public ResponseEntity<LibraryBooks> getBookId(long id);

    public LibraryBooks putBooks(LibraryBooks listOfBooksDetails);

    public ResponseEntity<Object> delBooks(long id);
}
