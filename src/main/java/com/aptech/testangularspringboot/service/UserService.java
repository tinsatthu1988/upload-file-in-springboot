package com.aptech.testangularspringboot.service;

import com.aptech.testangularspringboot.domain.User;
import com.aptech.testangularspringboot.exception.domain.EmailExistException;
import com.aptech.testangularspringboot.exception.domain.UserNotFoundException;
import com.aptech.testangularspringboot.exception.domain.UsernameExistException;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface UserService {
    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, EmailExistException, UsernameExistException, MessagingException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);

}
