package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.LibraryBooks;
import com.example.LibraryManagementSystem.Repository.LibraryBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LibraryBooksServiceImpl implements LibraryBooksService {
    @Autowired
    private LibraryBooksRepository listOfBooksRepository;
    private LibraryBooks listOfBooksDetails;

    public List<LibraryBooks> findAllBooks(){
        return listOfBooksRepository.findAll();
    }

    public LibraryBooks saveBooks(@RequestBody LibraryBooks listOfBooks){
        return listOfBooksRepository.save(listOfBooks);
    }

    public ResponseEntity<LibraryBooks> getBookId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
        LibraryBooks listOfBooks = listOfBooksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id Not Found : " + id));
        return ResponseEntity.ok().body(listOfBooks);
    }

    public LibraryBooks putBooks(@RequestBody LibraryBooks listOfBooksDetails) throws ResourceNotFoundException {
        this.listOfBooksDetails = listOfBooksDetails;
        long id = this.listOfBooksDetails.getId();
        LibraryBooks listOfBooks = listOfBooksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
        listOfBooks.setId(listOfBooks.getId());
        listOfBooks.setBookId(listOfBooksDetails.getBookId());
        listOfBooks.setLibraryId(listOfBooksDetails.getBookId());
        listOfBooksRepository.save(listOfBooks);
        return listOfBooks;
    }

    public ResponseEntity<Object> delBooks(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        listOfBooksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
        listOfBooksRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
