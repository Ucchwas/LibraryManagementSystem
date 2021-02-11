package com.example.LibraryManagementSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_id_seq")
    @SequenceGenerator(name = "library_id_seq", sequenceName = "library_id_seq", allocationSize = 1)
    private long id;

    @Column
    private String name;
}
