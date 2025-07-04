import java.util.ArrayList;


public class ShippingService {

    public static String shippingPayment(ArrayList<Product> shippableProducts) {
        StringBuilder shippingReceipt = new StringBuilder();
        double totalWeight = 0.0;

        shippingReceipt.append("** Shipping Notice **\n");
        for (Product product : shippableProducts) {
            double weight=1.1;
            if(product instanceof Shippable){
                weight =((Shippable) Main.Menu.get(product.getName())).getWeight();
            }else{
                if(product instanceof ShippableAndExpirable){
                    weight =((ShippableAndExpirable) Main.Menu.get(product.getName())).getWeight();
                }
            }

            double finalWeight = weight * product.getQuantity();
            totalWeight += finalWeight;
            shippingReceipt.append(product.getQuantity())
                    .append("x   ")
                    .append(product.getName())
                    .append("    ")
                    .append(finalWeight)
                    .append("g\n");
        }
        shippingReceipt.append("Total package weight     ")
                .append(totalWeight)
                .append("g\n\n");

        return shippingReceipt.toString();
    }
}
