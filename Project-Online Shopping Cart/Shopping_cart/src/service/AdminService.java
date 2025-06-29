package service;

import java.util.List;
import dao.AdminDAO;
import bean.Product;
import bean.User;
import bean.Order;

public class AdminService {

    private AdminDAO adminDAO = new AdminDAO();

    public List<User> getAllUsers() {
        return adminDAO.getAllUsers();
    }

    public List<Order> getAllOrders() {
        return adminDAO.getAllOrders();
    }

    public boolean addProduct(Product p) {
        return adminDAO.addProduct(p);
    }

    public boolean updateProduct(Product p) {
        return adminDAO.updateProduct(p);
    }

    public boolean deleteProduct(int id) {
        return adminDAO.deleteProduct(id);
    }
}

