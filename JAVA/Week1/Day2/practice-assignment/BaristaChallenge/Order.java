import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private List<Item> items;
    private boolean ready;

    public Order() {
        this.customerName = "Guest";
        this.items = new ArrayList<Item>();
        this.ready = false;
    }

    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<Item>();
        this.ready = false;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

   public boolean isReady() {
        return this.ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String getStatusMessage() {
        if (this.ready) {
            return "Your order is ready!";
        } else {
            return "Your order is not ready yet.";
        }
    }

    public double getOrderTotal() {
        double total = 0;
        for (Item item : this.items) {
            total += item.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.println("Order for " + this.customerName);
        System.out.println("Items:");
        for (Item item : this.items) {
            System.out.println("  - " + item.getName() + " ($" + item.getPrice() + ")");
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }
}
