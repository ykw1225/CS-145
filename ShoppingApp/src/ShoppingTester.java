/**
 * Created by 844915794 on 1/6/2015.
 */
public class ShoppingTester {

    public static void main (String[] args){

        System.out.println("Welcome to the shopping tester!");

        // create a shopping cart
        ShoppingCart singleItemCart = new ShoppingCart();

        // create a line item
        LineItem item1 = new LineItem("Marker", 2, 2.00);

        // add the line item into the cart
        singleItemCart.add(item1);

        double total = singleItemCart.getTotalCost();

        System.out.println("The total is " + total);

        ShoppingCart typicalCart = new ShoppingCart ();
        LineItem firstItem = new LineItem ("Sweater", 1, 50.00);
        LineItem secondItem = new LineItem ("Chunk Taylors", 1, 89.95);
        LineItem thirdItem = new LineItem ("Yoga pants", 1, 75.00);
        typicalCart.add (firstItem);
        typicalCart.add (secondItem);
        typicalCart.add (thirdItem);
        total = typicalCart.getTotalCost();
        System.out.println("The total of the typical cart is " + total);
    }
}
