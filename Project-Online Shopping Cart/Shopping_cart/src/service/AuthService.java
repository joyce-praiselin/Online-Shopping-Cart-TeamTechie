package service;

import bean.User;
import dao.UserDAO;

public class AuthService {

    private User currentUser;
    private UserDAO userDAO = new UserDAO();

    public boolean register(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAdmin(false);

        return userDAO.registerUser(user);
    }

    public boolean login(String email, String password) {
        User user = userDAO.loginUser(email, password);
        if (user != null) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public boolean isAdmin() {
        return currentUser != null && currentUser.isAdmin();
    }

    public void logout() {
        currentUser = null;
    }
}
