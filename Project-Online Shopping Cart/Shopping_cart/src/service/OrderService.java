package service;

import java.util.Date;
import java.util.List;
import bean.CartItem;
import bean.Order;
import dao.OrderDAO;

public class OrderService {

    private OrderDAO orderDAO = new OrderDAO();

    public int placeOrder(int userId, List<CartItem> items, double totalAmount) {
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderDate(new Date());
        order.setItems(items);
        order.setTotalAmount(totalAmount);
        return orderDAO.placeOrder(order);
    }
}
