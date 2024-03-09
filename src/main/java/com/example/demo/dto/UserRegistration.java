package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserRegistration {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
