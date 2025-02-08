package Programming2.Mod2.CT2;

public class BankAccount {

  private String firstName;
  private String lastName;
  private int accountID;
  private double balance;



  public BankAccount() {
    balance = 0;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAccountID() {
    return accountID;
  }

  public void setAccountID(int accountID) {
    this.accountID = accountID;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double in) {
    this.balance = this.balance + in;
  }

  public void withdrawal(double out) {
    this.balance = this.balance - out;
  }

  public String accountSummary() {
    return
    "Account ID: " + this.accountID + "\n" +
    "First Name: " + this.firstName + "\n" +
    "Last Name: " + this.lastName + "\n" +
    "Balance: " + this.balance;
  }

}
