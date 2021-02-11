package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.Books;
import com.example.LibraryManagementSystem.Repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;
    private Books booksDetails;

    public List<Books> findAllBooks(){
        return booksRepository.findAll();
    }

    public Books saveBooks(@RequestBody Books books){
        return booksRepository.save(books);
    }

    public ResponseEntity<Books> getBookId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
        Books books = booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Books Not Found : " + id));
        return ResponseEntity.ok().body(books);
    }

    public Books putBooks(@RequestBody Books booksDetails) throws ResourceNotFoundException {
        this.booksDetails = booksDetails;
        long id = this.booksDetails.getBookId();
        Books books = booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Books Not Found"));
        books.setBookId(booksDetails.getBookId());
        books.setBookType(booksDetails.getBookType());
        booksRepository.save(books);
        return books;
    }

    public ResponseEntity<Object> delBooks(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Books Not Found"));
        booksRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
