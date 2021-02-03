package com.example.LibraryManagementSystem.Resource;

import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.Library;
import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Service.LibraryService;
import com.example.LibraryManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryResource {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/library")
    public List<Library> getAllLibrary(){
        return libraryService.findAllLibrary();
    }

    @GetMapping("/library/{id}")
    public ResponseEntity<Library> getLibraryId(@PathVariable(value = "id")  long id){
        return libraryService.getLibraryId(id);
    }

    @PostMapping("/library")
    public Library createLibrary(@RequestBody Library library){
        return libraryService.saveLibrary(library);
    }

    @PostMapping("/library/{id}")
    public ResponseEntity<Library> getLibrarybyId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
        return libraryService.getLibraryId(id);
    }

    @PutMapping("/library")
    public ResponseEntity<Library> updateLibrary(@RequestBody Library libraryDetails) throws ResourceNotFoundException {
        return libraryService.putLibrary(libraryDetails);
    }

    @DeleteMapping("/library/{id}")
    public ResponseEntity<Object> deleteLibrary(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        return libraryService.delLibrary(id);
    }
}
