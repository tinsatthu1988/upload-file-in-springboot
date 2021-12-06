package com.aptech.testangularspringboot.controller;

import com.aptech.testangularspringboot.exception.ExceptionHandling;
import com.aptech.testangularspringboot.exception.domain.EmailExistException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = { "/", "/user"})
public class UserController extends ExceptionHandling {

    @GetMapping("/home")
    public String showUser() throws EmailExistException {
        //return "application works";
        throw new EmailExistException("This email address is already taken");
    }
}
