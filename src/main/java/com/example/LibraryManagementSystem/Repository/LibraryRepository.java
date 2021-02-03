package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
