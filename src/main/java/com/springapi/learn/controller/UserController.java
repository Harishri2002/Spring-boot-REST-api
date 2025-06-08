package com.springapi.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springapi.learn.model.User;
import com.springapi.learn.service.UserService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // Get user by ID
    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        logger.info("Getting user with ID: {}", userId);
        return userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Get all users
    @GetMapping
    public Iterable<User> getAllUsers() {
        logger.info("Getting all users");
        return userService.getAllUsers();
    }

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.info("Creating user with name: {}", user.getName());
        try {
            User savedUser = userService.saveUser(user);
            logger.info("User created successfully with ID: {}", savedUser.getId());
            return savedUser;
        } catch (Exception e) {
            logger.error("Error creating user: ", e);
            throw e;
        }
    }

    // Update an existing user
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        logger.info("Updating user with ID: {}", userId);
        return userService.getUserById(userId)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    return userService.saveUser(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Delete a user
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        logger.info("Deleting user with ID: {}", userId);
        userService.deleteUser(userId);
    }
}