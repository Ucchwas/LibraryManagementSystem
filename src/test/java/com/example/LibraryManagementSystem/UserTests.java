package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import com.example.LibraryManagementSystem.Service.UserService;
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
class UserTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		when(userRepository.findAll()).thenReturn(Stream.of(new User(1,"Member",2,"Good"),new User(2,"Admin",3,"Bad")).collect(Collectors.toList()));

		Assert.assertEquals(2,userService.findAllUser().size());
	}

}
