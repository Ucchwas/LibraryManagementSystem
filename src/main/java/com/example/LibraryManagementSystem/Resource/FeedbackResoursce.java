package com.example.LibraryManagementSystem.Resource;

import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.Feedback;
import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Service.FeedbackService;
import com.example.LibraryManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbackResoursce {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedback")
    public List<Feedback> getAllUser(){
        return feedbackService.findAllFeedback();
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getFeedbackId(@PathVariable(value = "id")  long id){
        return feedbackService.getFeedbackBookId(id);
    }

    @PostMapping("/feedback")
    public Feedback createFeedback(@RequestBody Feedback feedback){
        return feedbackService.saveFeedback(feedback);
    }

    @PostMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getFeedbackbyId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
        return feedbackService.getFeedbackBookId(id);
    }

    @PutMapping("/feedback")
    public ResponseEntity<Feedback> updateUser(@RequestBody Feedback feedbackDetails) throws ResourceNotFoundException {
        return feedbackService.putFeedback(feedbackDetails);
    }

    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<Object> deleteFeedback(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        return feedbackService.delFeedback(id);
    }
}
