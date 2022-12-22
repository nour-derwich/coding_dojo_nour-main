import java.util.ArrayList;
public class Order{
    public String name;
    public double total;
    public boolean ready;
    public  ArrayList<Item> items;
    public Order(String name)
    {
        this.name=name;
        this.items=new ArrayList<>();

    }
    public void addItem(Item item)
    {
        items.add(item);
        total+=item.getPrice();
    }
    public void markAsReady()
    {
        ready=true;
    }
    public String getName()
    {
        return name;
    }
    public double getTotal()
    {
        return total;
    }
    public boolean isReady()
    {
        return ready;
    }
    public ArrayList<Item> getItem()
    {
        return items;
    }
    // item class
   
        
}