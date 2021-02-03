package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
