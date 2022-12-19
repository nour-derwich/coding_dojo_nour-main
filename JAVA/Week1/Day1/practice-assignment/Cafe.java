public class Cafe {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
     double mochaPrice1 = 16.5;
      double mochaPrice2 = 30.5;
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer4 = "Sam";
        String customer3 = "Jimmy";
        String customer2 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
          boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
      
        System.out.println(generalGreeting + customer2 + displayTotalMessage +mochaPrice);
         System.out.println(customer2  + pendingMessage);
         if (isReadyOrder3) {
            System.out.println(customer3 + readyMessage);
            System.out.println(displayTotalMessage + mochaPrice1);
        }
        else {
            System.out.println(customer3 + pendingMessage);
        }

         System.out.println(displayTotalMessage + mochaPrice2 * 2);
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }
        
    }
}
