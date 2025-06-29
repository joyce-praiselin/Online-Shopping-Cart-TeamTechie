package dao;

import java.sql.*;
import java.util.*;
import bean.CartItem;
import bean.Product;
import util.DBConnection;

public class CartDAO {
    public void clearUserCart(int userId) {
        String sql = "DELETE FROM cart WHERE user_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other methods like getCartByUserId, saveCartItem could be added if using persistent cart
}

