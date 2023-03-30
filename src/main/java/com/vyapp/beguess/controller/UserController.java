package com.vyapp.beguess.controller;

import com.vyapp.beguess.data.User;
import com.vyapp.beguess.service.UserServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@Log
@RequestMapping("/users")
public class UserController {

    private final UserServiceImp userService;

    @PostMapping
    @RequestMapping("/registrations")
    ResponseEntity<User> create(@Validated @RequestBody User user) {
        User newUser = userService.attemptRegistration(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping
    @RequestMapping("/sightin")
    ResponseEntity<User> enter(@Validated @RequestBody User user) {
        User newUser = userService.sightIn(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/updateStatuses")
    public void updateStation() {
        userService.updateStatuses();
    }

    @GetMapping("/getall")
    ResponseEntity<ArrayList<User>> index() {
        return ResponseEntity.ok((ArrayList<User>) userService.listUsers());
    }

    @PostMapping
    @RequestMapping("/updauseranswer")
    ResponseEntity<User> rightAnswerState(@Validated @RequestBody User user) {
        return ResponseEntity.ok(userService.rightAnswerState(user));
    }

    @GetMapping("/getalltrue")
    ResponseEntity<List<User>> listUserStatuses() {
        return ResponseEntity.ok(userService.listUserStatuses());
    }

    @GetMapping("/getUser")
    ResponseEntity<User> getUser(@Validated @RequestBody User user) {
        return ResponseEntity.ok(userService.retrieveUserData(user.getUsername()));
    }

}
