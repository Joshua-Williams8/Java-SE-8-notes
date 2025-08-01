package CSC450.MOD7;

public class CheckingsAccount {

  private double amount;

  public void deposit(double in) {
    amount = amount + in;
  }
  public void withdraw(double out) {
    amount = amount - out;
  }



}
