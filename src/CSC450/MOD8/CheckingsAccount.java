package CSC450.MOD8;

public class CheckingsAccount {

  private double amount;

  public void deposit(double in) throws BankingException {
    if (in < 0) {
      throw new BankingException("Cannot deposit less than 0!");
    }
    amount = amount + in;
  }
  public void withdraw(double out) {
    if (out < 0) {
      throw new BankingException("Cannot withdraw less than 0!");
    }

    amount = amount - out;
  }
}
