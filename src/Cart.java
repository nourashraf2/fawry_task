import java.time.LocalDate;
import java.util.ArrayList;

public class Cart {
    ArrayList<Product> products = new ArrayList<Product>();

    public Cart() {
    }

    public void addProduct(String name, int quantity,Product menuItem){
        if(menuItem.getExpirable()!=null){
            if (menuItem.getExpirable().getExpiryDate().isBefore(LocalDate.now()) ||
                    menuItem.getExpirable().getExpiryDate().isEqual(LocalDate.now())) {
                throw new Error("You are trying to add an expired product");
            }
        }
        if(menuItem.getQuantity()<quantity){
            throw new Error("qunatity ordered is more than the available stock");
        }
        if(menuItem.getQuantity()==0){
            throw new Error("out of stock");
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
