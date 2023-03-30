package com.vyapp.beguess.service;

import com.vyapp.beguess.data.User;
import com.vyapp.beguess.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User attemptRegistration(User user) {

        if (!usernameExists(user.getUsername())) {

            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            newUser.setPlace(user.getPlace());
            newUser.setScore(user.getScore());
            newUser.setStatus(user.isStatus());

            userRepository.save(newUser);

            obscurePassword(newUser);
            return newUser;
        }

        throw new RuntimeException("Пользователь " + user.getUsername() + " уже существует.");

    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> listUserStatuses() {
        return userRepository.findAllByStatus(true);
    }

    @Override
    public User retrieveUserData(String username) {
        User user = userRepository.findByUsername(username);
        obscurePassword(user);
        return user;
    }

    @Override
    public User sightIn(User _user) {
        User user = userRepository.findByUsername(_user.getUsername());
        if (_user.getPassword().equals(user.getPassword())) {
            return user;
        }
        throw new RuntimeException("Неверный логин или пароль.");
    }

    @Override
    public User retrieveUserData(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            obscurePassword(user);
            return user;
        }

        throw new RuntimeException("Пользователь с id:" + id + " не существует.");
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

    @Override
    public void updateStatuses() {

        List<User> users = listUsers();

        for (User u : users) {
            userRepository.updateStatus(u.getId(), false);
        }

    }

    @Override
    public void updateStatus(String username, boolean status) {

        long id = userRepository.findByUsername(username).getId();
        userRepository.updateStatus(id, status);

    }

    @Override
    public void updateScore(String username, long score) {
        long id = userRepository.findByUsername(username).getId();
        userRepository.updateScore(id,score);
    }

    public User rightAnswerState(User user){
        updateStatus(user.getUsername(), true);
        List<User> users = listUserStatuses();
        long score = (500 / users.size()) + user.getScore();
        updateScore(user.getUsername(), score);
        user.setScore(score);
        user.setStatus(true);
        return user;
    }

    private void obscurePassword(User user) {
        user.setPassword("XXX");
    }
}
