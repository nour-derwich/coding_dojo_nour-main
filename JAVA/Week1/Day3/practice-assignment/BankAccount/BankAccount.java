import java.util.Random;
public class BankAccount 
{    String accountNumber;
     static double totalAmount=0;
    double checkingBalance;
    double savingsBalance;
    static int AccountCount=0 ;
    public BankAccount()
    {
        this.checkingBalance=0;
        this.savingsBalance=0;
        this.accountNumber=generateAccountNumber();
        AccountCount++;
    }
      // getter methods
  public double getCheckingBalance() {
    return checkingBalance;
  }
  public double getSavingsBalance() {
    return savingsBalance;
  }
  public void deposit(double amount, String accountType)
  {
    if(accountType.equalsIgnoreCase("checking"))
    {
         checkingBalance += amount;
    }else if (accountType.equalsIgnoreCase("savings")) {
      savingsBalance += amount;
    }
    totalAmount += amount;
  }
  public void withdraw(double amount, String accountType) {

    if (accountType.equalsIgnoreCase("checking")) {
      if (checkingBalance - amount >= 0) {
        checkingBalance -= amount;
        totalAmount -= amount;
      } else {
        System.out.println("Insufficient funds in checking account");
      }
    } else if (accountType.equalsIgnoreCase("savings")) {
      if (savingsBalance - amount >= 0) {
        savingsBalance -= amount;
        totalAmount -= amount;
      } else {
        System.out.println("Insufficient funds in savings account");
      }
    }
  }
   public double getTotal() {
    return checkingBalance + savingsBalance;
  }
//   
 private String generateAccountNumber() {
    Random random = new Random();
    String accountNumber = "";
    for (int i = 0; i < 10; i++) {
      accountNumber += random.nextInt(10);
    }
    return accountNumber;
  }
}