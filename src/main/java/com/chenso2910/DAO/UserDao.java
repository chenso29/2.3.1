package com.chenso2910.DAO;

import com.chenso2910.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    User getUser(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);

}
