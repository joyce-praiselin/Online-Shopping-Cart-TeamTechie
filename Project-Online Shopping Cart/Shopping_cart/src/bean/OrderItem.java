package bean;

public class OrderItem {
    private int orderItemId;
    private int orderId;
    private Product product;
    private int quantity;
    private double price;

    public OrderItem() {}

    public OrderItem(int orderItemId, int orderId, Product product, int quantity, double price) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

