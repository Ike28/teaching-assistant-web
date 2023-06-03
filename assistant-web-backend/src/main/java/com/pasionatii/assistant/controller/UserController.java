package com.pasionatii.assistant.controller;

import com.pasionatii.assistant.entity.User;
import com.pasionatii.assistant.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assistant/users")
public class UserController {
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @PostMapping("/login")
    public User login(@RequestBody User existingUser) {
        return userRepository.findByEmailAndPasswordToken(existingUser.getEmail(), existingUser.getPassword());
    }
}
