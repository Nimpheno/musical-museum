package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationEntity {
        private String firstName;
    private String lastName;
    private String email;
    private String password;
}
