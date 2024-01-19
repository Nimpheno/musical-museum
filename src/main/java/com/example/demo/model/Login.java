package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

public class Login {
    @NotNull
    @Length(min = 4, max = 20)
    protected String username;

    @NotNull
    @JsonProperty(access = WRITE_ONLY)
    @Length(min = 8, max = 100)
    private String password;
}
