package test;

import model.User;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        // Test user registration
        User newUser = new User("Kshitij", "kshitij@example.com", "password123");
        boolean registered = userService.register(newUser);
        if (registered) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Registration failed.");
        }

        // Test user login
        User loggedInUser = userService.login("kshitij@example.com", "password123");
        if (loggedInUser != null) {
            System.out.println("Login successful! Welcome " + loggedInUser.getName());
        } else {
            System.out.println("Login failed: invalid credentials.");
        }
    }
}
