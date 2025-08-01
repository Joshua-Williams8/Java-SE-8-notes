package CSC450.MOD7;

public class CheckingsAccountRunner {
  public static void main(String[] args) {
    CheckingsAccount accountOne = new CheckingsAccount();
    // accountOne.amount = 5000; //Do not allow the amount to be directly defined
    accountOne.deposit(5000);
    accountOne.withdraw(200);
  }
}
