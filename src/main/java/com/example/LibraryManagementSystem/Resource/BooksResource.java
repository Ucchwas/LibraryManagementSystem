package com.example.LibraryManagementSystem.Resource;

import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.Books;
import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Service.BooksService;
import com.example.LibraryManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksResource {
    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    public List<Books> getAllBooks(){
        return booksService.findAllBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getBooksId(@PathVariable(value = "id")  long id){
        return booksService.getBookId(id);
    }

    @PostMapping("/books")
    public Books createBooks(@RequestBody Books books){
        return booksService.saveBooks(books);
    }

    @PostMapping("/books/{id}")
    public ResponseEntity<Books> getBooksbyId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
        return booksService.getBookId(id);
    }

    @PutMapping("/books")
    public ResponseEntity<Books> updateUser(@RequestBody Books booksDetails) throws ResourceNotFoundException {
        return booksService.putBooks(booksDetails);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBooks(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        return booksService.delBooks(id);
    }
}
