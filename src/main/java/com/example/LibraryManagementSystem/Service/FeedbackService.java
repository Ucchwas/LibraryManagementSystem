package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.Feedback;
import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    private Feedback feedbackDetails;

    public List<Feedback> findAllFeedback(){
        return feedbackRepository.findAll();
    }

    public Feedback saveFeedback(@RequestBody Feedback feedback){
        return feedbackRepository.save(feedback);
    }

    public ResponseEntity<Feedback> getFeedbackBookId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
        Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book Not Found : " + id));
        return ResponseEntity.ok().body(feedback);
    }

    public ResponseEntity<Feedback> putFeedback(@RequestBody Feedback feedbackDetails) throws ResourceNotFoundException {
        this.feedbackDetails = feedbackDetails;
        long id = this.feedbackDetails.getBookId();
        Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
        feedback.setUserId(feedbackDetails.getBookId());
        feedback.setBookId(feedbackDetails.getBookId());
        feedback.setRating(feedbackDetails.getRating());
        feedbackRepository.save(feedback);
        return ResponseEntity.ok().body(feedback);
    }

    public ResponseEntity<Object> delFeedback(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        feedbackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
        feedbackRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
