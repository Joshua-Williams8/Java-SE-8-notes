package CSC450.MOD8;

public class CheckingsAccountRunner {
  public static void main(String[] args) {
    CheckingsAccount accountOne = new CheckingsAccount();
    accountOne.deposit(5000);
    accountOne.withdraw(200);
    try {
      accountOne.withdraw(-1000);
    } catch (BankingException e) {
      System.out.println(e.getMessage());
      //Prints my custom message for the exception
    }
  }
}
