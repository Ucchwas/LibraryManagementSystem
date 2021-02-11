package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.Books;
import com.example.LibraryManagementSystem.Model.Library;
import com.example.LibraryManagementSystem.Repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService{
    @Autowired
    private LibraryRepository libraryRepository;
    private Library libraryDetails;

    public List<Library> findAllLibrary(){
        List<Library> libraries = libraryRepository.findAll();
        System.out.println("New Books: "+ libraries.toString());
        return libraryRepository.findAll();
    }

    public Library saveLibrary(@RequestBody Library library){
        return libraryRepository.save(library);
    }

    public ResponseEntity<Library> getLibraryId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
        Library library = libraryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Library Not Found : " + id));
        return ResponseEntity.ok().body(library);
    }

    public Library putLibrary(@RequestBody Library libraryDetails) throws ResourceNotFoundException {
        this.libraryDetails = libraryDetails;
        long id = this.libraryDetails.getId();
        Library library = libraryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Library Not Found"));
        library.setId(libraryDetails.getId());
        library.setName(libraryDetails.getName());
        libraryRepository.save(library);
        return library;
    }

    public ResponseEntity<Object> delLibrary(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        libraryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        libraryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
