package Programming2.Mod1.CT;

public class CheckingAccount extends BankAccount {
  private double interestRate;

  public void processWithdrawal(double pOut) {
    withdrawal(pOut);
    if (super.getBalance() < 0) {
      withdrawal(30);
      System.out.println("You did not have enough money in your account, and the account has received a $30 overdraft fee.");
    }
  }

  public void displayAccount() {
    super.accountSummary();
    System.out.println("Interest Rate: " + this.interestRate);
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double newRate){
    this.interestRate = newRate;
  }

}
