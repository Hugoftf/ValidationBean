package com.github.Hugoftf.Validation_Spring.controller;

import com.github.Hugoftf.Validation_Spring.entity.User;
import com.github.Hugoftf.Validation_Spring.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {

        userRepository.save(user);

        return ResponseEntity.ok().body(user);
    }

}
