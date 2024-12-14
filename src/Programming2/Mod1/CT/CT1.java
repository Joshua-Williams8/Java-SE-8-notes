package Programming2.Mod1.CT;

public class CT1 {
  public static void main(String[] args) {
    CheckingAccount testAccount = new CheckingAccount();
    testAccount.setFirstName("James");
    testAccount.setLastName("Brown");
    testAccount.setAccountID(1234);
    testAccount.setInterestRate(0.02);
    testAccount.displayAccount();
    System.out.println("-------");

    testAccount.deposit(50);
    testAccount.displayAccount();
    System.out.println("-------");

    testAccount.processWithdrawal(40);
    testAccount.displayAccount();
    System.out.println("-------");

    testAccount.processWithdrawal(20);
    testAccount.displayAccount();
  }

}
