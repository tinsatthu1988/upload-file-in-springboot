package com.aptech.testangularspringboot.controller;

import com.aptech.testangularspringboot.exception.ExceptionHandling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends ExceptionHandling {

    @GetMapping("/home")
    public String showUser(){
        return "application works";
    }
}
