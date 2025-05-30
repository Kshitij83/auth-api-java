package controller;

import model.User;
import service.UserService;

public class UserController {
    private UserService userService = new UserService();

    public String registerUser(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        boolean result = userService.register(user);
        return result ? "Registration successful!" : "Registration failed. Email might already exist.";
    }

    public String loginUser(String email, String password) {
        User user = userService.login(email, password);
        return user != null ? "Login successful!" : "Invalid email or password.";
    }
}
