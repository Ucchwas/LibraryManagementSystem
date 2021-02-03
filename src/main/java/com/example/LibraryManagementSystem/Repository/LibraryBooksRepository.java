package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.LibraryBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryBooksRepository extends JpaRepository<LibraryBooks, Long> {
}
