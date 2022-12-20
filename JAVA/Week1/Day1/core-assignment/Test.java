public class Test {
	

     public static void main(String[] args) {
String a = "same string";
String b = "same string";
System.out.println(a == b); // true
// Creating new strings as separate objects (another way to create a String)
a = new String("same letters");
b = new String("same letters");
System.out.println(a == b); // false. Not the same object in memory.
System.out.println(a.equals(b)); 
}}