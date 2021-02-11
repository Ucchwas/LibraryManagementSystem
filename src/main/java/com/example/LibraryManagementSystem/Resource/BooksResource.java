package com.example.LibraryManagementSystem.Resource;

import com.example.LibraryManagementSystem.DTO.BooksDTO;
import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.Books;
import com.example.LibraryManagementSystem.Service.BooksService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class BooksResource {
    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    public List<BooksDTO> getAllBooks(){

        return booksService.findAllBooks().stream().map(BooksDTO::new).collect(Collectors.toList());
    }
//
//    @GetMapping("/books/{id}")
//    public ResponseEntity<Books> getBooksId(@PathVariable(value = "id")  long id){
//        return booksService.getBookId(id);
//    }

    @PostMapping("/books")
    public BooksDTO createBooks(@RequestBody Books books){
        //BooksDTO booksDTO = modelMapper.map(books , BooksDTO.class);
        return new BooksDTO(booksService.saveBooks(books));
    }

//    @PostMapping("/books/{id}")
//    public ResponseEntity<Books> getBooksbyId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
//        return booksService.getBookId(id);
//    }

    @PutMapping("/books")
    public BooksDTO updateUser(@RequestBody Books books){
        return new BooksDTO(booksService.putBooks(books));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBooks(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        return booksService.delBooks(id);
    }
}
