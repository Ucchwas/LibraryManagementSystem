package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.Library;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LibraryService {
    public List<Library> findAllLibrary();

    public Library saveLibrary(Library library);

    public ResponseEntity<Library> getLibraryId(long id);

    public Library putLibrary(Library libraryDetails);

    public ResponseEntity<Object> delLibrary(long id);
}
