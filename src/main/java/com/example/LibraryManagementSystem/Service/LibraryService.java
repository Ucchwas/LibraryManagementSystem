package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.Library;
import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;
    private Library libraryDetails;

    public List<Library> findAllLibrary(){
        return libraryRepository.findAll();
    }

    public Library saveLibrary(@RequestBody Library library){
        return libraryRepository.save(library);
    }

    public ResponseEntity<Library> getLibraryId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
        Library library = libraryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Library Not Found : " + id));
        return ResponseEntity.ok().body(library);
    }

    public ResponseEntity<Library> putLibrary(@RequestBody Library libraryDetails) throws ResourceNotFoundException {
        this.libraryDetails = libraryDetails;
        long id = this.libraryDetails.getId();
        Library library = libraryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Library Not Found"));
        library.setId(libraryDetails.getId());
        library.setName(libraryDetails.getName());
        library.setBookId(libraryDetails.getBookId());
        library.setUserId(libraryDetails.getUserId());
        libraryRepository.save(library);
        return ResponseEntity.ok().body(library);
    }

    public ResponseEntity<Object> delLibrary(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        libraryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        libraryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
