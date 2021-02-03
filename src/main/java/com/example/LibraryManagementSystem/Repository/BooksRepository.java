package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
