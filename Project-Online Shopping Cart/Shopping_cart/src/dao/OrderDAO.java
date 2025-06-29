package dao;

import java.sql.*;
import java.util.Date;
import bean.Order;
import util.DBConnection;

public class OrderDAO {

    public int placeOrder(Order order) {
        int orderId = -1;
        String sql = "INSERT INTO orders (user_id, order_date, total_amount) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, order.getUserId());
            ps.setTimestamp(2, new Timestamp(new Date().getTime()));
            ps.setDouble(3, order.getTotalAmount());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId;
    }
}
