package servlet;

import model.User;
import service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class MainServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); // "register" or "login"
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("register".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = new User(name, email, password);
            boolean success = userService.register(user);

            if (success) {
                out.println("User registered successfully.");
            } else {
                out.println("Registration failed.");
            }
        } else if ("login".equals(action)) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = userService.login(email, password);
            if (user != null) {
                out.println("Login successful. Welcome, " + user.getName() + "!");
            } else {
                out.println("Invalid credentials.");
            }
        } else {
            out.println("Invalid action.");
        }
    }
}
