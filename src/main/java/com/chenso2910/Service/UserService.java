package com.chenso2910.Service;

import com.chenso2910.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    User getUser(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
