package com.rinos.controllers;

import com.rinos.entity.UserEntity;
import com.rinos.exception.ResourceNotFoundException;
import com.rinos.models.User;
import com.rinos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

//    @GetMapping
//    public String getUsers() {
//        return "Hello API";
//    }
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserEntity>  getUsers() {
//        return Arrays.asList(new User(1L, "Rinos", "rinos@gmail.com"),
//                new User(2L, "Rosy", "rosy@gmail.com"),
//                new User(3L, "Ramlan", "ramlan@gmail.com"));
        return userRepository.findAll();
    }

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        UserEntity userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userData.setName(userEntity.getName());
        userData.setEmail(userEntity.getEmail());
        return userRepository.save(userData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        UserEntity userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userRepository.delete(userData);
        return ResponseEntity.ok().build();
    }
}
