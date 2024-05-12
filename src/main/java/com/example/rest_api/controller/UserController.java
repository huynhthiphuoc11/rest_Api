package com.example.rest_api.controller;
import com.example.rest_api.Entity.User;
import com.example.rest_api.Repository.UserRepository;
import com.example.rest_api.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @DeleteMapping("/user/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        userRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable Long id, @RequestBody User userUpdate) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userUpdate.getName());
            user.setEmail(userUpdate.getEmail());
            user.setAddress(userUpdate.getAddress());
            user.setContactNo(userUpdate.getContactNo());
            user.setRole(userUpdate.getRole());
            user.setPassword(userUpdate.getPassword());
            user.setClassName(userUpdate.getClassName());
            user.setClassId(userUpdate.getClassId());
            return userRepository.save(user);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

}
