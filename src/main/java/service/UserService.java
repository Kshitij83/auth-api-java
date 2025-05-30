package service;

import dao.UserDao;
import model.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public boolean register(User user) {
        return userDao.registerUser(user);
    }

    public User login(String email, String password) {
        return userDao.loginUser(email, password);
    }
}
