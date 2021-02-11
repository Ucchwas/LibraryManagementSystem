package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.Feedback;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FeedbackService {
    public List<Feedback> findAllFeedback();

    public Feedback saveFeedback(Feedback feedback);

    public ResponseEntity<Feedback> getFeedbackBookId(long id);

    public Feedback putFeedback(Feedback feedbackDetails);

    public ResponseEntity<Object> delFeedback(long id);
}
