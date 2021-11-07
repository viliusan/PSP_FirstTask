package com.example.library;

import com.example.library.model.User;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ActionHandler {

    Scanner scanner = new Scanner(System.in);

    private final UserService userService;

    public void addUser() {
        System.out.println("-------------------------------------");
        System.out.println("You've chosen to add a new user. Please enter the following details:");
        System.out.println("Name:");
        var name = scanner.next();
        System.out.println("Last name:");
        var lastName = scanner.next();
        System.out.println("Phone number:");
        var phoneNumber = scanner.next();
        System.out.println("Email:");
        var email = scanner.next();
        System.out.println("Address:");
        var address = scanner.next();
        System.out.println("Password:");
        var password = scanner.next();

        var user = User.builder().name(name).lastName(lastName).phoneNumber(phoneNumber).email(email).address(address).password(password).build();
        var userId = userService.addUser(user);

        if (userId != null) {
            System.out.println("User saved with user ID of " + userId);
        } else {
            System.out.println("User creation failed");
        }
    }

    public void updateUserById() {
        System.out.println("-------------------------------------");
        System.out.println("You've chosen to update user info by ID. Please enter the following details:");
        System.out.println("ID:");
        var id = scanner.nextLong();
        System.out.println("Name:");
        var name = scanner.next();
        System.out.println("Last name:");
        var lastName = scanner.next();
        System.out.println("Phone number:");
        var phoneNumber = scanner.next();
        System.out.println("Email:");
        var email = scanner.next();
        System.out.println("Address:");
        var address = scanner.next();
        System.out.println("Password:");
        var password = scanner.next();

        var user = User.builder().id(id).name(name).lastName(lastName).phoneNumber(phoneNumber).email(email).address(address).password(password).build();
        userService.updateUser(user);

    }

    public void listAllUsers() {
        var users = userService.getAllUsers();
        System.out.println("Listing all users:");
        users.forEach(user -> System.out.println(user.getName() + " " + user.getLastName()));
    }

    public void listUserById() {
        System.out.println("You've chosen to list a user by ID. Please enter a user ID:");
        var id = scanner.nextLong();
        var user = userService.getUserById(id);

        if (user != null) {
            System.out.println(user.getName() + " " + user.getLastName() + " " + user.getEmail());
        } else {
            System.out.println("User with entered ID does not exist.");
        }
    }

    public void deleteUserById() {
        System.out.println("You've chosen to delete a user by ID. Please enter a user ID:");
        var id = scanner.nextLong();
        var user = userService.getUserById(id);

        if (user != null) {
            userService.deleteById(id);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User with entered ID does not exist.");
        }
    }

}
