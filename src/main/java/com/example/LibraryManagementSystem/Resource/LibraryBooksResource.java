package com.example.LibraryManagementSystem.Resource;

import com.example.LibraryManagementSystem.DTO.BooksDTO;
import com.example.LibraryManagementSystem.DTO.LibraryBooksDTO;
import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.Library;
import com.example.LibraryManagementSystem.Model.LibraryBooks;
import com.example.LibraryManagementSystem.Service.LibraryBooksService;
import com.example.LibraryManagementSystem.Service.LibraryBooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LibraryBooksResource {
    @Autowired
    private LibraryBooksService libraryBooksService;

    @GetMapping("/listOfBooks")
    public List<LibraryBooksDTO> getAllBooks(){
        return libraryBooksService.findAllBooks().stream().map(LibraryBooksDTO::new).collect(Collectors.toList());
    }

//    @GetMapping("/listOfBooks/{id}")
//    public ResponseEntity<LibraryBooks> getBookId(@PathVariable(value = "id")  long id){
//        return libraryBooksService.getBookId(id);
//    }

    @PostMapping("/listOfBooks")
    public LibraryBooksDTO createBooks(@RequestBody LibraryBooks libraryBooks){
        return new LibraryBooksDTO(libraryBooksService.saveBooks(libraryBooks));
    }

//    @PostMapping("/listOfBooks/{id}")
//    public ResponseEntity<LibraryBooks> getBooksbyId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
//        return libraryBooksService.getBookId(id);
//    }

    @PutMapping("/listOfBooks")
    public LibraryBooksDTO updateBooks(@RequestBody LibraryBooks listOfBooksDetails){
        return new LibraryBooksDTO(libraryBooksService.putBooks(listOfBooksDetails));
    }

    @DeleteMapping("/listOfBooks/{id}")
    public ResponseEntity<Object> deleteBooks(@PathVariable(value = "id") long id){
        return libraryBooksService.delBooks(id);
    }
}
