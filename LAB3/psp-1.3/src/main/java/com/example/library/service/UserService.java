package com.example.library.service;

import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.library.validator.EmailValidator;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long addUser(User user) {
        if (validateFields(user)) {
            return userRepository.save(user).getId();
        }
        return null;
    }

    public void updateUser(User updatedUser) {
        var user = userRepository.findById(updatedUser.getId()).orElse(null);
        if (user != null && validateFields(updatedUser)) {
            userRepository.save(updatedUser);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

//    private boolean validateFields(User user) {
//        EmailValidator emailValidator = new EmailValidator();
//        PasswordChecker passwordChecker = new PasswordChecker();
//        NumberValidator numberValidator = new NumberValidator();
//
//        var validatedEmail = emailValidator.validate(user.getEmail());
//        var validatedPassword = passwordChecker.validatePassword(user.getPassword());
//        var validatedNumber = numberValidator.validateNumber(user.getPhoneNumber());
//
//        if (!validatedEmail) {
//            System.out.println("ERROR. Bad email.");
//        }
//
//        if (!validatedPassword) {
//            System.out.println("ERROR. Bad password.");
//        }
//
//        if (!validatedNumber) {
//            System.out.println("ERROR. Bad phone number.");
//        }
//
//        return validatedEmail && validatedNumber && validatedPassword;
//    }
}
