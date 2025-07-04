import java.time.LocalDate;
import java.util.ArrayList;

public class Cart {
    ArrayList<Product> products = new ArrayList<Product>();

    public Cart() {
    }

    public void addProduct(String name, int quantity){
        Product product=Main.Menu.get(name);
        if(product instanceof Expirable ){
            Expirable expirable = (Expirable) Main.Menu.get(name);
            if(expirable.getExpiryDate().isBefore(LocalDate.now())  || expirable.getExpiryDate().equals(LocalDate.now())){
                throw new Error("Product is Expired");
            }
        }
        if(product instanceof ShippableAndExpirable ){
            ShippableAndExpirable shippableAndExpirable = (ShippableAndExpirable) Main.Menu.get(name);
            if(shippableAndExpirable.getExpiryDate().isBefore(LocalDate.now())  || shippableAndExpirable.getExpiryDate().equals(LocalDate.now())){
                throw new Error("Product is Expired");
            }
        }
        if(product.getQuantity()<quantity){
            throw new Error("un available amount");
        }

        products.add(new Product(name,quantity));
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }


}
