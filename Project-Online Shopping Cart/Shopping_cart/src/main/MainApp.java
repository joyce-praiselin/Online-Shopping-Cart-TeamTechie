package main;

import java.util.List;
import java.util.Scanner;

import bean.CartItem;
import bean.Product;
import bean.User;
import service.AdminService;
import service.AuthService;
import service.CartService;
import service.OrderService;
import service.PaymentService;
import service.ProductService;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AuthService authService = new AuthService();
        ProductService productService = new ProductService();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        while (true) {
            System.out.println("\n--- Online Shopping Cart ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                if (authService.register(name, email, password)) {
                    System.out.println("Registration successful.");
                } else {
                    System.out.println("Registration failed.");
                }
            }

            else if (choice == 2) {
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();

                if (authService.login(email, password)) {
                    System.out.println("Login successful.");
                    User currentUser = authService.getCurrentUser();

                    if (currentUser.isAdmin()) {
                        AdminService adminService = new AdminService();
                        while (true) {
                            System.out.println("\n--- Admin Menu ---");
                            System.out.println("1. View All Users");
                            System.out.println("2. View All Orders");
                            System.out.println("3. Add Product");
                            System.out.println("4. Update Product");
                            System.out.println("5. Delete Product");
                            System.out.println("6. Logout");
                            System.out.print("Enter choice: ");

                            int adminChoice = 0;
                            try {
                                adminChoice = Integer.parseInt(sc.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input.");
                                continue;
                            }

                            if (adminChoice == 1) {
                                List<User> users = adminService.getAllUsers();
                                for (User u : users) {
                                    System.out.println("ID: " + u.getId() + ", Name: " + u.getName() +
                                            ", Email: " + u.getEmail() + ", Admin: " + u.isAdmin());
                                }
                            } else if (adminChoice == 2) {
                                List<bean.Order> orders = adminService.getAllOrders();
                                for (bean.Order o : orders) {
                                    System.out.println("Order ID: " + o.getOrderId() + ", User ID: " + o.getUserId() +
                                            ", Date: " + o.getOrderDate() + ", Amount: ₹" + o.getTotalAmount());
                                }
                            } else if (adminChoice == 3) {
                                System.out.print("Enter product name: ");
                                String name = sc.nextLine();
                                System.out.print("Enter category: ");
                                String category = sc.nextLine();
                                System.out.print("Enter price: ");
                                double price = Double.parseDouble(sc.nextLine());
                                System.out.print("Enter stock: ");
                                int stock = Integer.parseInt(sc.nextLine());

                                Product p = new Product(0, name, category, price, stock);
                                boolean added = adminService.addProduct(p);
                                System.out.println(added ? "Product added." : "Failed to add.");
                            } else if (adminChoice == 4) {
                                System.out.print("Enter product ID to update: ");
                                int id = Integer.parseInt(sc.nextLine());
                                System.out.print("Enter new name: ");
                                String name = sc.nextLine();
                                System.out.print("Enter new category: ");
                                String category = sc.nextLine();
                                System.out.print("Enter new price: ");
                                double price = Double.parseDouble(sc.nextLine());
                                System.out.print("Enter new stock: ");
                                int stock = Integer.parseInt(sc.nextLine());

                                Product p = new Product(id, name, category, price, stock);
                                boolean updated = adminService.updateProduct(p);
                                System.out.println(updated ? "Product updated." : "Update failed.");
                            } else if (adminChoice == 5) {
                                System.out.print("Enter product ID to delete: ");
                                int id = Integer.parseInt(sc.nextLine());
                                boolean deleted = adminService.deleteProduct(id);
                                System.out.println(deleted ? "Deleted." : "Failed to delete.");
                            } else if (adminChoice == 6) {
                                authService.logout();
                                System.out.println("Admin logged out.");
                                break;
                            } else {
                                System.out.println("Invalid choice.");
                            }
                        }
                    } else {
                        while (true) {
                            System.out.println("\n--- Menu ---");
                            System.out.println("1. View Products");
                            System.out.println("2. Add to Cart");
                            System.out.println("3. View Cart");
                            System.out.println("4. Delete item from Cart");
                            System.out.println("5. Payment");
                            System.out.println("6. Logout");
                            System.out.print("Enter choice: ");

                            int action = 0;
                            try {
                                action = Integer.parseInt(sc.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a number.");
                                continue;
                            }

                            if (action == 1) {
                                List<Product> products = productService.getAllProducts();
                                for (Product p : products) {
                                    System.out.println(p.getId() + ". " + p.getName() + " - ₹" + p.getPrice() + " | Stock: " + p.getStock());
                                }
                            } else if (action == 2) {
                                System.out.print("Enter product ID: ");
                                int pid = Integer.parseInt(sc.nextLine());

                                System.out.print("Enter quantity: ");
                                int qty = Integer.parseInt(sc.nextLine());

                                Product product = productService.getProductById(pid);
                                if (product != null && product.getStock() >= qty) {
                                    cartService.addToCart(product, qty);
                                    System.out.println("Added to cart.");
                                } else {
                                    System.out.println("Product not found or insufficient stock.");
                                }
                            } else if (action == 3) {
                                List<CartItem> items = cartService.getCartItems();
                                if (items.isEmpty()) {
                                    System.out.println("Cart is empty.");
                                } else {
                                    for (CartItem item : items) {
                                        System.out.println(item.getProduct().getName() + " x" + item.getQuantity() + " = ₹" + item.getTotalPrice());
                                    }
                                    System.out.println("Total: ₹" + cartService.getTotalAmount());
                                }
                            } else if (action == 4) {
                                List<CartItem> items = cartService.getCartItems();
                                if (items.isEmpty()) {
                                    System.out.println("Cart is empty.");
                                } else {
                                    for (CartItem item : items) {
                                        System.out.println(item.getProduct().getId() + " - " + item.getProduct().getName() + " x" + item.getQuantity());
                                    }
                                    System.out.print("Enter Product ID to remove from cart: ");
                                    int removeId = Integer.parseInt(sc.nextLine());
                                    cartService.removeFromCart(removeId);
                                    System.out.println("Item removed from cart.");
                                }
                            } else if (action == 5) {
                                if (cartService.getCartItems().isEmpty()) {
                                    System.out.println("Cart is empty.");
                                    continue;
                                }
                                double total = cartService.getTotalAmount();
                                PaymentService.PaymentOption option = paymentService.choosePaymentMethod();
                                paymentService.processPayment(option, total);

                                int orderId = orderService.placeOrder(currentUser.getId(), cartService.getCartItems(), total);
                                if (orderId != -1) {
                                    System.out.println("Order placed successfully. Order ID: " + orderId);
                                    cartService.clearCart();
                                } else {
                                    System.out.println("Failed to place order.");
                                }
                            } else if (action == 6) {
                                authService.logout();
                                System.out.println("Logged out.");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Invalid credentials.");
                }
            }

            else if (choice == 3) {
                System.out.println("Thank you :)");
                break;
            }
        }

        sc.close();
    }
}
