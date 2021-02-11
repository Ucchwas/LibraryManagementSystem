package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.Model.Books;
import com.example.LibraryManagementSystem.Model.Feedback;
import com.example.LibraryManagementSystem.Repository.BooksRepository;
import com.example.LibraryManagementSystem.Repository.FeedbackRepository;
import com.example.LibraryManagementSystem.Service.BooksService;
import com.example.LibraryManagementSystem.Service.FeedbackService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class FeedbackTests {
    @Autowired
    private FeedbackService feedbackService;

    @MockBean
    private FeedbackRepository feedbackRepository;

    @Test
    void contextLoads() {
        when(feedbackRepository.findAll()).thenReturn(Stream.of(new Feedback(1, 1, (long) 2),new Feedback(2,2, (long) 4)).collect(Collectors.toList()));

        Assert.assertEquals(2,feedbackService.findAllFeedback().size());
    }
}
