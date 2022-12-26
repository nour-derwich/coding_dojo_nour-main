import java.util.ArrayList;
import java.util.Scanner;

class Item {
  // instance variables
  private String name;
  private double price;
  private int index;

  // constructor
  public Item(String name, double price, int index) {
    this.name = name;
    this.price = price;
    this.index = index;
  }

  // getter and setter methods
  public String getName() {
    return name;
  }
  public double getPrice() {
    return price;
  }
  public int getIndex() {
    return index;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public void setIndex(int index) {
    this.index = index;
  }
}

class Order {
  // instance variables
  private Item item;
  private int quantity;

  // constructor
  public Order(Item item, int quantity) {
    this.item = item;
    this.quantity = quantity;
  }

  // getter and setter methods
  public Item getItem() {
    return item;
  }
  public int getQuantity() {
    return quantity;
  }
  public void setItem(Item item) {
    this.item = item;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}

class CoffeeKiosk {
  // class attributes
  private ArrayList<Item> menu;
  private ArrayList<Order> orders;

  // constructor
  public CoffeeKiosk() {
    menu = new ArrayList<>();
    orders = new ArrayList<>();
  }

  // method to add menu item
public void addMenuItem(String name, double price) {
    int index = menu.size();
    Item item = new Item(name, price, index);
    menu.add(item);
  }}