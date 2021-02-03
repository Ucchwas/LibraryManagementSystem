package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private User userDetails;

    public List<User>findAllUser(){
        return userRepository.findAll();
    }

    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }

    public ResponseEntity<User> getUserId(@PathVariable(value = "id")  long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found : " + id));
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<User> putUser(@RequestBody User userDetails) throws ResourceNotFoundException {
        this.userDetails = userDetails;
        long id = this.userDetails.getUserId();
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        user.setUserId(userDetails.getUserId());
        user.setUserType(userDetails.getUserType());
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<Object> delUser(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
