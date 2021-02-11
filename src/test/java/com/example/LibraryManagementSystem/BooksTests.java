package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.Model.Books;
import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Repository.BooksRepository;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import com.example.LibraryManagementSystem.Service.BooksService;
import com.example.LibraryManagementSystem.Service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class BooksTests {
    @Autowired
    private BooksService booksService;

    @MockBean
    private BooksRepository booksRepository;

    @Test
    void contextLoads() {
        when(booksRepository.findAll()).thenReturn(Stream.of(new Books(1,"ME"), new Books(2,"CSE")).collect(Collectors.toList()));

        Assert.assertEquals(2,booksService.findAllBooks().size());
    }
}
