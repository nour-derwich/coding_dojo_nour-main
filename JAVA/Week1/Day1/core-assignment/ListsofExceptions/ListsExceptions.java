import java.util.ArrayList;
public class ListsExceptions {
  public static void main(String[] args) {
    ArrayList<Object> list = new ArrayList<>();
    list.add("13");
    list.add("hello world");
    list.add(25);
    list.add("Goodbye World");

    

    // Try to cast each element to an Integer
    for (Object element : list) {
      try {
        
        Integer num = (Integer) element;
        System.out.println(num);
      } catch (ClassCastException e) {
        System.out.println("Cannot cast " + element + " to Integer.");
      }
    }
  }
}