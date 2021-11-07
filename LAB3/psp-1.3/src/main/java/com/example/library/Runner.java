package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    ActionHandler actionHandler;

    @Override
    public void run(String... args) throws Exception {
        Scanner in = new Scanner(System.in);
        displayOptions();
        var choice = in.nextInt();

        do {
            switch (choice) {
                case 1:
                    actionHandler.addUser();
                    break;
                case 2:
                    actionHandler.updateUserById();
                    break;
                case 3:
                    actionHandler.listAllUsers();
                    break;
                case 4:
                    actionHandler.listUserById();
                    break;
                case 5:
                    actionHandler.deleteUserById();
                    break;
            }
            displayOptions();
            choice = in.nextInt();
        } while (choice < 6 && choice > 0);

    }

    private void displayOptions() {
        System.out.println("------------------------");
        System.out.println("1. Create a new user");
        System.out.println("2. Update user by ID");
        System.out.println("3. List all users");
        System.out.println("4. List user by ID");
        System.out.println("5. Delete user by ID");
        System.out.println("------------------------");
    }

}
