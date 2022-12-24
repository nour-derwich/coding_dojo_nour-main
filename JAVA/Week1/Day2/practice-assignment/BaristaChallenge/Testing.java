public class Testing {
    public static void main(String[] args) {
        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("Alice");
        Order order4 = new Order("Bob");

        Item item1 = new Item("Coffee", 3.50);
        Item item2 = new Item("Bagel", 2.75);
        Item item3 = new Item("Croissant", 3.25);

        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item3);

        order3.addItem(item1);
        order3.addItem(item2);
        order3.addItem(item3);
        order4.addItem(item1);

        order3.setReady(true);
        System.out.println(order3.getStatusMessage());

        System.out.println(order1.getOrderTotal());

        order3.display();
    }
}
