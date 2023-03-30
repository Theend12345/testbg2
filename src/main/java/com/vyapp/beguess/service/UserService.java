package com.vyapp.beguess.service;

import com.vyapp.beguess.data.User;

import java.util.List;

interface UserService {

    User attemptRegistration(User user);

    List<User> listUsers();
    List<User> listUserStatuses();

    User retrieveUserData(String username);

    User sightIn(User _user);

    User retrieveUserData(long id);

    boolean usernameExists(String username);

    void updateStatuses();

    void updateStatus(String username, boolean status);

    void updateScore(String username, long score);
}
