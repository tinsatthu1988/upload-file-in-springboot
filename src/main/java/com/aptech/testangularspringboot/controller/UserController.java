package com.aptech.testangularspringboot.controller;

import com.aptech.testangularspringboot.domain.User;
import com.aptech.testangularspringboot.exception.ExceptionHandling;
import com.aptech.testangularspringboot.exception.domain.EmailExistException;
import com.aptech.testangularspringboot.exception.domain.UserNotFoundException;
import com.aptech.testangularspringboot.exception.domain.UsernameExistException;
import com.aptech.testangularspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = { "/", "/user"})
public class UserController extends ExceptionHandling {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws UserNotFoundException, UsernameExistException, EmailExistException {
        User newUser = userService.register(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail());
        return new ResponseEntity<>(newUser, OK);
    }
}
