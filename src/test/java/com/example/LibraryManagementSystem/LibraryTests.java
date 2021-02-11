package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.Model.Books;
import com.example.LibraryManagementSystem.Model.Library;
import com.example.LibraryManagementSystem.Repository.BooksRepository;
import com.example.LibraryManagementSystem.Repository.LibraryRepository;
import com.example.LibraryManagementSystem.Service.BooksService;
import com.example.LibraryManagementSystem.Service.LibraryService;
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
class LibraryTests {
    @Autowired
    private LibraryService libraryService;

    @MockBean
    private LibraryRepository libraryRepository;

    @Test
    void contextLoads() {
        when(libraryRepository.findAll()).thenReturn(Stream.of(new Library(1,"Ekota"),new Library(2,"Jononi")).collect(Collectors.toList()));

        Assert.assertEquals(2,libraryService.findAllLibrary().size());
    }
}
