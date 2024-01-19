package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;


    @PostMapping(path = "/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User userDetails) {
        userService.registerUser(userDetails);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }
}
