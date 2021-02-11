package com.example.LibraryManagementSystem.DTO;

import com.example.LibraryManagementSystem.Model.Library;

public class LibraryDTO {
    private long id;

    private String name;

    public LibraryDTO(Library library) {
        this.id = library.getId();
        this.name = library.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
