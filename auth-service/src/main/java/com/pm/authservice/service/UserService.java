package com.pm.authservice.service;

import com.pm.authservice.model.User;
import com.pm.authservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    //Dependency Injection
    private final UserRepository userRepository;

    //Constructor
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email); // further calls repository level to get user by email
    }
}
