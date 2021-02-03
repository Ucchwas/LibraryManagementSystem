package com.example.LibraryManagementSystem.Resource;

import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.LibraryBooks;
import com.example.LibraryManagementSystem.Service.LibraryBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryBooksResource {
    @Autowired
    private LibraryBooksService libraryBooksService;

    @GetMapping("/listOfBooks")
    public List<LibraryBooks> getAllBooks(){
        return libraryBooksService.findAllBooks();
    }

    @GetMapping("/listOfBooks/{id}")
    public ResponseEntity<LibraryBooks> getBookId(@PathVariable(value = "id")  long id){
        return libraryBooksService.getBookId(id);
    }

    @PostMapping("/listOfBooks")
    public LibraryBooks createBooks(@RequestBody LibraryBooks libraryBooks){
        return libraryBooksService.saveBooks(libraryBooks);
    }

    @PostMapping("/listOfBooks/{id}")
    public ResponseEntity<LibraryBooks> getBooksbyId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
        return libraryBooksService.getBookId(id);
    }

    @PutMapping("/listOfBooks")
    public ResponseEntity<LibraryBooks> updateBooks(@RequestBody LibraryBooks listOfBooksDetails) throws ResourceNotFoundException {
        return libraryBooksService.putBooks(listOfBooksDetails);
    }

    @DeleteMapping("/listOfBooks/{id}")
    public ResponseEntity<Object> deleteBooks(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        return libraryBooksService.delBooks(id);
    }
}
