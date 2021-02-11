package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public List<User> findAllUser();

    public User saveUser(User user);

    public ResponseEntity<User> getUserId(long id);

    public User putUser(User userDetails);

    public ResponseEntity<Object> delUser(long id);
}
