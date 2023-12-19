package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void deleteUser(String userId);
    User updateUser(User user);
    User getUserById(String userId);

    List<User> getAllUsers();
}