import java.util.ArrayList;

public class TestOrderItem{
    public static void main(String[] args)
    {
        

        // Set the price and name for each drink
Item mocha = new Item("Mocha", 3.50);
Item latte = new Item("Latte", 2.50);
Item dripCoffee = new Item("Drip Coffee", 1.50);
Item cappuccino = new Item("Cappuccino", 2.75);

// Create 4 order variables and instantiate each as an Order object
Order order1 = new Order("Cindhuri", new ArrayList<>(), 0, false);
Order order2 = new Order("Jimmy", new ArrayList<>(), 0, false);
Order order3 = new Order("Noah", new ArrayList<>(), 0, false);
Order order4 = new Order("Sam", new ArrayList<>(), 0, false);
       // Add item1 to order2's item list and increment the order's total
Item item1 = latte;
order2.getItems().add(item1);
order2.setTotal(order2.getTotal() + item1.getPrice());

// order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.
order3.getItems().add(cappuccino);
order3.setTotal(order3.getTotal() + cappuccino.getPrice());

    }
}