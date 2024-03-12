package com.example.demo.services;

import com.example.demo.config.Jwt.AuthenticationRequest;
import com.example.demo.dto.CredentialsDto;
import com.example.demo.exceptions.UserException;
import com.example.demo.entity.UserEntity;
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

    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(UserEntity userDetails) {
        if (userRepository.findByUsername(userDetails.getUsername()).isPresent()) {
            throw new UserException("User already exists!");
        }
        //https://www.baeldung.com/spring-security-5-default-password-encoder
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));

        userRepository.insert(userDetails);
    }

    public String login(CredentialsDto credentials) {
        Optional<UserEntity> user = userRepository.findByUsername(credentials.getUsername());

        if (user.isEmpty()) {
            // throw new InvalidCredentialsException("There is not such user");
            throw new IllegalArgumentException("There is not such user");
        }
        String hashedPass = passwordEncoder.encode(credentials.getPassword());
        if (!user.get().getPassword().equals(hashedPass)){

        }
        //user.get().getPassword()

        // TODO: check the hashed password
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(credentials.getUsername(), credentials.getPassword());
//        String testToken = authenticationService.authenticate(authenticationRequest).getToken();
//        System.out.println(testToken);
        return user.get().getId();
    }

    public UserEntity getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException(String.format("User with id %s does not exist", id)));
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(String.format("User with username %s does not exist", username)));
    }

}
