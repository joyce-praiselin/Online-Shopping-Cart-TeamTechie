# Capstone-Project

# 🛒 Shopping Cart System

A **console-based Shopping Cart System** built using **Java (JDK 21)** and **MySQL**, developed by **Team Techie**. The system handles user registration, product catalog, cart operations, order placement, and basic admin operations with a modular code structure.

---

## 👥 Team Techie

| Name            | Role                          |
|-----------------|-------------------------------|
| Joyce Praiselin | Team Leader, Developer        |
| Vishal          | Backend Developer, Tester     |
| Tharun          | Database Designer, Developer  |
| Anitha          | UI Logic Designer, Presenter  |
| Abarna          | Documentation, Tester         |

> ✅ Each member participated in coding, testing, and refining the entire project collaboratively.

---

## 📁 Project Structure

Shopping_cart/
├── src/
│ ├── bean/ # POJOs / Data Models
│ │ ├── CartItem.java
│ │ ├── Order.java
│ │ ├── OrderItem.java
│ │ ├── PaymentOption.java
│ │ ├── Product.java
│ │ └── User.java
│ │
│ ├── dao/ # Data Access Layer
│ │ ├── AdminDAO.java
│ │ ├── CartDAO.java
│ │ ├── OrderDAO.java
│ │ ├── ProductDAO.java
│ │ └── UserDAO.java
│ │
│ ├── service/ # Business Logic Layer
│ │ ├── AdminService.java
│ │ ├── AuthService.java
│ │ ├── CartService.java
│ │ ├── OrderService.java
│ │ ├── PaymentService.java
│ │ └── ProductService.java
│ │
│ ├── util/ # Utilities
│ │ └── DBConnection.java
│ │
│ ├── main/ # Application Entry Point
│ │ └── MainApp.java
│
├── module-info.java


---

## 🚀 Key Features

- 👥 **User Management**: Registration and login
- 📦 **Product Catalog**: View and browse products
- 🛒 **Cart Operations**: Add, view, and remove items
- 📤 **Place Order**: Convert cart to order and simulate payment
- 💳 **Payment Options**: Choose between payment modes
- 📑 **Order History**: View past orders (basic)
- 🛠️ **Admin Features**: View all users/orders/products (via DAO/service)

---

## ⚙️ Technologies Used

- Java 21 (JDK)
- JDBC API
- MySQL (DB)
- Eclipse IDE
- Git & GitHub

---

## 🧪 Sample Menu (MainApp.java)

```plaintext
==== Welcome to Shopping Cart ====

1. Register
2. Login
3. Browse Products
4. Add Product to Cart
5. View Cart
6. Remove from Cart
7. Place Order
8. Payment
9. View Order History
10. Admin Login (optional)
11. Exit


