package com.example.demo.services;

import com.example.demo.exceptions.UserException;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public void registerUser(User userDetails) {
        if (userRepository.findByUsername(userDetails.getUsername()).isPresent()) {
            throw new UserException("User already exists!");
        }
        //TODO encode and decode passwords
        //https://www.baeldung.com/spring-security-5-default-password-encoder
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        userDetails.setPassword(encoder.encode(userDetails.getPassword()));

        userRepository.insert(userDetails);
    }

    public String login(User userDetails) {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        userDetails.setPassword(encoder.encode(userDetails.getPassword()));
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
        if (user.isEmpty()) {
            // throw new InvalidCredentialsException("There is not such user");
             throw new IllegalArgumentException("There is not such user");
        }
        // TODO: check the hashed password

        return user.get().getId();
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException(String.format("User with id %s does not exist", id)));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(String.format("User with username %s does not exist", username)));
    }

}
