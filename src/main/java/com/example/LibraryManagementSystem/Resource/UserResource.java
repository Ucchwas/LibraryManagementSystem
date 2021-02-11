package com.example.LibraryManagementSystem.Resource;

import com.example.LibraryManagementSystem.DTO.UserDTO;
import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

    //Logger logger = LoggerFactory.getLogger(UserResource.class);

    @GetMapping("/users")
    public List<UserDTO> getAllUser(){
        //logger.error("Error");
        return userService.findAllUser().stream().map(UserDTO::new).collect(Collectors.toList());
    }

//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getUserId(@PathVariable(value = "id")  long id){
//        return userService.getUserId(id);
//    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody User user){
        return new UserDTO(userService.saveUser(user));
    }

//    @PostMapping("/users/{id}")
//    public ResponseEntity<User> getUserbyId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
//        return userService.getUserId(id);
//    }

    @PutMapping("/users")
    public UserDTO updateUser(@RequestBody User userDetails){
        return new UserDTO(userService.putUser(userDetails));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") long id){
        return userService.delUser(id);
    }
}
