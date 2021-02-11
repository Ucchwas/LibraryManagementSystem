package com.example.LibraryManagementSystem.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_id_seq")
    @SequenceGenerator(name = "library_id_seq", sequenceName = "library_id_seq", allocationSize = 1)
    private long id;

    @Column
    private String name;


    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Library(long id, String name){
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
        super();
    }
}
