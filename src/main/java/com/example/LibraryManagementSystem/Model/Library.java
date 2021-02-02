package com.example.LibraryManagementSystem.Model;

import java.util.List;


public class Library {
    private int id;
    private String name;
    private List<String> listofBooks;
    int bookId;
    int userId;
    public Library(int id,String name,int bookId,int userId){
        this.id = id;
        this.name = name;
        this.bookId = bookId;
        this.userId = userId;
    }
}
