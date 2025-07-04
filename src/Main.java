import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static HashMap<String,Product> Menu = new HashMap<>();

    public static void loadMenuProducts(){
        Product cheese = new ShippableAndExpirable("Cheese", 55.0, 20,1.2,
                LocalDate.of(2025, 12, 10));

        Product biscuits = new Expirable("Biscuits", 15.0, 50,
                LocalDate.of(2024, 12, 20));

        Product tv = new Shippable("TV", 15000.0, 5, 12.0);

        Product scratchCard = new Product("Scratch Card", 20.0, 100);

        Product frozenPizza = new ShippableAndExpirable("Frozen Pizza", 45.0, 15,1.0,
                LocalDate.of(2024, 11, 1));

        Product laptop = new Shippable("Laptop", 23000.0, 10, 2.5);

        Menu.put("Cheese",cheese);
        Menu.put("Biscuits",biscuits);
        Menu.put("TV",tv);
        Menu.put("Scratch Card",scratchCard);
        Menu.put("Frozen Pizza",frozenPizza);
        Menu.put("Laptop",laptop);



    }
    public static void checkout(Customer customer,Cart cart){
        if (cart.getProducts().isEmpty()) {
            throw new Error("Cart is Empty");
        }

        ArrayList<Product> cartProducts = cart.getProducts();
        ArrayList<Product> shippableProduct = new ArrayList<>();

        for (Product product : cartProducts) {
            if (Menu.get(product.getName()) instanceof Shippable || Menu.get(product.getName()) instanceof ShippableAndExpirable ) {
                shippableProduct.add(product);
            }
        }

        StringBuilder receipt = new StringBuilder();

        receipt.append(ShippingService.shippingPayment(shippableProduct));

        receipt.append("** Checkout Receipt **\n");
        double totalPrice = 0.0;

        for (Product product : cartProducts) {
            double price = Main.Menu.get(product.getName()).getPrice();
            double finalPrice = price * product.getQuantity();
            Main.Menu.get(product.getName()).setQuantity(Main.Menu.get(product.getName()).getQuantity()-product.getQuantity());
            totalPrice += finalPrice;
            receipt.append(product.getQuantity()).append("x   ")
                    .append(product.getName()).append("    ")
                    .append(finalPrice).append("\n");
        }

        receipt.append("Subtotal    ").append(totalPrice).append("\n");
        receipt.append("Shipping    30\n");
        receipt.append("Amount    ").append(totalPrice + 30.0).append("\n");
        customer.checkCustomerBalance(totalPrice+30.0);
        customer.decrementCustomerBalance(totalPrice+30.0);
        System.out.println(receipt.toString());
        System.out.println(customer.getBalance());

    }




    public static void main(String[] args) {
       loadMenuProducts();

//        Customer customer1 = new Customer("Nour", 1500.0);
//        Cart cart1 = new Cart();
//        cart1.addProduct("Cheese", 2);
//        cart1.addProduct("Scratch Card", 3);
//        Main.checkout(customer1, cart1);


//        Customer customer3 = new Customer("Ahmed", 300.0);
//        Cart cart3 = new Cart();
//        cart3.addProduct("Biscuits", 1);
//        Main.checkout(customer3, cart3);
//




//        Customer customer2 = new Customer("Lina", 100.0);
//        Cart cart2 = new Cart();
//        Main.checkout(customer2, cart2);
//
//

//
        Customer customer4 = new Customer("Sara", 50.0); // small balance
        Cart cart4 = new Cart();

        cart4.addProduct("Cheese", 1);
        cart4.addProduct("TV", 1); // 15000
        Main.checkout(customer4, cart4);


//        Customer customer5 = new Customer("Omar", 100000.0);
//        Cart cart5 = new Cart();
//        cart5.addProduct("Laptop", 100); // Only 10 in stock
//        Main.checkout(customer5, cart5);

//
//
//        Customer customer6 = new Customer("Nadine", 25000.0);
//        Cart cart6 = new Cart();
//        cart6.addProduct("Laptop", 1);
//        Main.checkout(customer6, cart6);  // Should include shipping weight
//


    }
}