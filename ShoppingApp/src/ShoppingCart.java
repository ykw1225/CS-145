/**
 * Created by 844915794 on 1/6/2015.
 */
public class ShoppingCart {
    public static final int CART_SIZE = 10;
    private int itemsInCart;
    private LineItem lineItems [];

    public ShoppingCart (){
        lineItems = new LineItem[CART_SIZE];
        itemsInCart = 0;
    }

    public void add (LineItem newItem){
        if (itemsInCart < 10) {
            lineItems [itemsInCart] = newItem;
            itemsInCart++;
        }
        else {
            System.out.println ("Cart is full. New item not added.");
        }
    }

    public double getTotalCost(){
        double totalCost = 0.0;
        for (int i = 0; i < itemsInCart; i++){
            totalCost += lineItems[i].getCost();
        }
        return totalCost;
    }
}
