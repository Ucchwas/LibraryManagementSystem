package com.example.LibraryManagementSystem.Resource;

import com.example.LibraryManagementSystem.DTO.BooksDTO;
import com.example.LibraryManagementSystem.DTO.LibraryDTO;
import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.Library;
import com.example.LibraryManagementSystem.Service.LibraryService;
import com.example.LibraryManagementSystem.Service.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LibraryResource {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/library")
    public List<LibraryDTO> getAllLibrary(){
        return libraryService.findAllLibrary().stream().map(LibraryDTO::new).collect(Collectors.toList());
    }

//    @GetMapping("/library/{id}")
//    public ResponseEntity<Library> getLibraryId(@PathVariable(value = "id")  long id){
//        return libraryService.getLibraryId(id);
//    }

    @PostMapping("/library")
    public LibraryDTO createLibrary(@RequestBody Library library){
        return new LibraryDTO(libraryService.saveLibrary(library));
    }

//    @PostMapping("/library/{id}")
//    public ResponseEntity<Library> getLibrarybyId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
//        return libraryService.getLibraryId(id);
//    }

    @PutMapping("/library")
    public LibraryDTO updateLibrary(@RequestBody Library libraryDetails){
        return new LibraryDTO(libraryService.putLibrary(libraryDetails));
    }

    @DeleteMapping("/library/{id}")
    public ResponseEntity<Object> deleteLibrary(@PathVariable(value = "id") long id) {
        return libraryService.delLibrary(id);
    }
}
