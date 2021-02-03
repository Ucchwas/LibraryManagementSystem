package com.example.LibraryManagementSystem.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;


    public Library(long id,String name){
        this.id = id;
        this.name = name;
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

    public Library() {
    }
}
