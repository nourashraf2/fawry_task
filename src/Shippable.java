public class Shippable extends Product {
    private Double weight;


    public Shippable(String name, Double price, int quantity, Double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
