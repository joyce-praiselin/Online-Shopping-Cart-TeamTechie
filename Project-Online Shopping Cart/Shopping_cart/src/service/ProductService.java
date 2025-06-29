package service;

import java.util.List;
import dao.ProductDAO;
import bean.Product;

public class ProductService {

    private ProductDAO productDAO = new ProductDAO();

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    public boolean updateStock(int productId, int newStock) {
        return productDAO.updateStock(productId, newStock);
    }
}

