package com.example.LibraryManagementSystem.Resource;

import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import com.example.LibraryManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.findAllUser();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserId(@PathVariable(value = "id")  long id){
        return userService.getUserId(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<User> getUserbyId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
        return userService.getUserId(id);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User userDetails) throws ResourceNotFoundException {
        return userService.putUser(userDetails);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        return userService.delUser(id);
    }
}
