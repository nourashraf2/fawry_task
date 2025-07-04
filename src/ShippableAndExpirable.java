import java.time.LocalDate;

public class ShippableAndExpirable extends Product{
    private Double weight;
    private LocalDate expiryDate;

    public ShippableAndExpirable(String name, Double price, int quantity, Double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
