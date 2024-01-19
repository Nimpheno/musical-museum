package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;

    @NotNull
    @Length(min = 4, max = 20)
    protected String username;

    @NotNull
    @JsonProperty(access = WRITE_ONLY)
    @Length(min = 8, max = 100)
    private String password;

    @NotNull
    @Email
    private String email;

    @AssertTrue(message = "username or email is required")
    private boolean isUsernameOrEmailExists(){
        return username != null || email != null;
    }


}
