public class TestBankAccount {
  public static void main(String[] args) {
    BankAccount myAccount = new BankAccount();

    // deposit 1000 into checking account
    myAccount.deposit((double) 1000, "checking");
    System.out.println("Checking balance: $" + myAccount.getCheckingBalance());

    // deposit 2000 into savings account
    myAccount.deposit((double) 2000, "savings");
    System.out.println("Savings balance: $" + myAccount.getSavingsBalance());

    // withdraw 500 from checking account
    myAccount.withdraw((double) 500, "checking");
    System.out.println("Checking balance: $" + myAccount.getCheckingBalance());

    // withdraw 1000 from savings account
    myAccount.withdraw((double) 1000, "savings");
    System.out.println("Savings balance: $" + myAccount.getSavingsBalance());

    // try to withdraw 2000 from checking account (insufficient funds)
    myAccount.withdraw((double) 2000, "checking");

    // get total money from checking and savings
    System.out.println("Total balance: $" + myAccount.getTotal());

    // NINJA BONUS: print account number
    System.out.println("Account number: " + myAccount.accountNumber);
  }
}
