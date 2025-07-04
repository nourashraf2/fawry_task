public class Product {
    private String name;
    private Double price;
    private int quantity;
    private Expirable expirable ;
    private Shippable shippable;

    public Product(String name, Double price, int quantity, Expirable expirable, Shippable shippable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirable = expirable;
        this.shippable = shippable;
    }


    //this is used to add product in the cart
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Expirable getExpirable() {
        return expirable;
    }

    public void setExpirable(Expirable expirable) {
        this.expirable = expirable;
    }

    public Shippable getShippable() {
        return shippable;
    }

    public void setShippable(Shippable shippable) {
        this.shippable = shippable;
    }
}
