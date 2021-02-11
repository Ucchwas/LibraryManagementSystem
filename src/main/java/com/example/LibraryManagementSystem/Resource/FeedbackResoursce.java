package com.example.LibraryManagementSystem.Resource;

import com.example.LibraryManagementSystem.DTO.BooksDTO;
import com.example.LibraryManagementSystem.DTO.FeedbackDTO;
import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.Feedback;
import com.example.LibraryManagementSystem.Service.FeedbackService;
import com.example.LibraryManagementSystem.Service.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FeedbackResoursce {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedback")
    public List<FeedbackDTO> getAllUser(){
        return feedbackService.findAllFeedback().stream().map(FeedbackDTO::new).collect(Collectors.toList());
    }

//    @GetMapping("/feedback/{id}")
//    public ResponseEntity<Feedback> getFeedbackId(@PathVariable(value = "id")  long id){
//        return feedbackService.getFeedbackBookId(id);
//    }

    @PostMapping("/feedback")
    public FeedbackDTO createFeedback(@RequestBody Feedback feedback){
        return new FeedbackDTO(feedbackService.saveFeedback(feedback));
    }

//    @PostMapping("/feedback/{id}")
//    public ResponseEntity<Feedback> getFeedbackbyId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
//        return feedbackService.getFeedbackBookId(id);
//    }

    @PutMapping("/feedback")
    public FeedbackDTO updateUser(@RequestBody Feedback feedbackDetails){
        return new FeedbackDTO(feedbackService.putFeedback(feedbackDetails));
    }

    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<Object> deleteFeedback(@PathVariable(value = "id") long id){
        return feedbackService.delFeedback(id);
    }
}
