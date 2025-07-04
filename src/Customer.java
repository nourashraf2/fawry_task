public class Customer {
    private String name;
    private Double balance;

    public Customer(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void decrementCustomerBalance(Double amount){
        this.balance=this.balance-amount;
    }


    public void checkCustomerBalance(Double amount){
        if(amount > this.balance ){
           throw new Error("no enough balance");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
