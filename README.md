# 📦 E-Commerce System – Test Cases

This document outlines test cases for validating the `Cart.addProduct(String name, int quantity, Product menuItem)` method and the `Main.checkout(Customer, Cart)` process in a basic e-commerce system.

---

## ✅ Test Case 1: Valid Checkout (Cheese + Scratch Card)

```java
Customer customer1 = new Customer("Nour", 1500.0);
Cart cart1 = new Cart();
cart1.addProduct("Cheese", 2, Menu.get("Cheese"));
cart1.addProduct("Scratch Card", 3, Menu.get("Scratch Card"));
Main.checkout(customer1, cart1);
```

### ✔️ Expected:
- Both products are valid (not expired, in stock).
- Customer balance is sufficient.
- Prints receipt and shipping weight.

---

## ❌ Test Case 2: Add Expired Product (Biscuits)

```java
Customer customer3 = new Customer("Ahmed", 300.0);
Cart cart3 = new Cart();
cart3.addProduct("Biscuits", 1, Menu.get("Biscuits"));
Main.checkout(customer3, cart3);
```

### ⚠ Expected:
- Throws `Error: You are trying to add an expired product`

---

## ❌ Test Case 3: Checkout with Empty Cart

```java
Customer customer2 = new Customer("Lina", 100.0);
Cart cart2 = new Cart();
Main.checkout(customer2, cart2);
```

### ⚠ Expected:
- Throws `Error: Cart is Empty`

---

## ❌ Test Case 4: Insufficient Balance

```java
Customer customer4 = new Customer("Sara", 50.0);
Cart cart4 = new Cart();
cart4.addProduct("Cheese", 1, Menu.get("Cheese"));
cart4.addProduct("TV", 1, Menu.get("TV"));
Main.checkout(customer4, cart4);
```

### ⚠ Expected:
- Throws `Error: Insufficient balance`

---

## ❌ Test Case 5: Quantity Exceeds Stock

```java
Customer customer5 = new Customer("Omar", 100000.0);
Cart cart5 = new Cart();
cart5.addProduct("Laptop", 100, Menu.get("Laptop")); // Only 10 in stock
Main.checkout(customer5, cart5);
```

### ⚠ Expected:
- Throws `Error: Quantity ordered is more than the available stock`

---

## ✅ Test Case 6: Shippable Product Only (Laptop)

```java
Customer customer6 = new Customer("Nadine", 25000.0);
Cart cart6 = new Cart();
cart6.addProduct("Laptop", 1, Menu.get("Laptop"));
Main.checkout(customer6, cart6);
```

### ✔️ Expected:
- Shipping section prints.
- Product added successfully.
- Checkout proceeds normally.

---

## ℹ️ Notes

- Be sure to call `Main.loadMenuProducts()` before running any tests.
- Menu must contain up-to-date product stock and expiry dates.
