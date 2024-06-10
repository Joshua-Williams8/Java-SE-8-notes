package collegeCSC320.ModuleThreeP;

import java.util.Scanner;

public class TaxEstimateWeekly {

  private static String roundNumber(float number) {
    return String.format("%.2f", number);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    float weeklyIncome = 0;
    float taxRate;
    float taxPaid;
    float takeHome;

    boolean noExceptionThrown = false;

    while(!noExceptionThrown) {
      try {
        System.out.println("Please enter your weekly income? (decimal numbers can be entered)");
        weeklyIncome = scanner.nextFloat();

        while (weeklyIncome < 0) {
          System.out.println("Sorry your input is invalid please enter a positive number.");
          weeklyIncome = scanner.nextFloat();
        }
        noExceptionThrown = true;
      } catch (Exception ex) {
        System.out.println("Sorry your input caused an exception. \n" + ex.toString());
        System.out.println("Please try to enter a valid value.");
        scanner.next();
        noExceptionThrown = false;
      }
    }

    if (weeklyIncome < 500) {
      taxRate = .10F;

    } else if (weeklyIncome < 1500) {
      taxRate = .15F;

    } else if (weeklyIncome < 2500) {
      taxRate = .20F;

    } else {
      taxRate = .30F;

    }

    taxPaid = taxRate * weeklyIncome;
    takeHome = weeklyIncome - taxPaid;

    System.out.println("With your weekly income of $" + weeklyIncome +", you pay "
      + roundNumber(taxRate * 100F) + "% of your weekly pay which is $" +
      roundNumber(taxPaid) +" in taxes. After paying taxes you take home $"+
      roundNumber(takeHome) + ".");


  }
}
