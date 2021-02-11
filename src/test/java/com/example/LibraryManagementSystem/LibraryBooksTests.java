package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.Model.Books;
import com.example.LibraryManagementSystem.Model.Library;
import com.example.LibraryManagementSystem.Model.LibraryBooks;
import com.example.LibraryManagementSystem.Repository.BooksRepository;
import com.example.LibraryManagementSystem.Repository.LibraryBooksRepository;
import com.example.LibraryManagementSystem.Repository.LibraryRepository;
import com.example.LibraryManagementSystem.Service.BooksService;
import com.example.LibraryManagementSystem.Service.LibraryBooksService;
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
class LibraryBooksTests {
    @Autowired
    private LibraryBooksService libraryBooksService;

    @MockBean
    private LibraryBooksRepository libraryBooksRepository;

    @Test
    void contextLoads() {
        when(libraryBooksRepository.findAll()).thenReturn(Stream.of(new LibraryBooks(1, 2, 1),new LibraryBooks(2,1,2)).collect(Collectors.toList()));

        Assert.assertEquals(2,libraryBooksService.findAllBooks().size());
    }
}
