package collegeCSC320.ModuleFour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OptionOneCT {

  //Total
  private static float getTotal(List<Float> floatList){
    float total = 0F;
    for (int i = 0; i < floatList.size(); ++i){
      total = total + floatList.get(i);
    }
    return total;
  }

  //Average
  private static float getAverage(List<Float> floatList){
    float total = getTotal(floatList);
    float average = total/ floatList.size();
    return average;
  }

  //Maximum
  private static float getMax(List<Float> floatList){
    float max = floatList.get(0);
    for (int i = 0; i < floatList.size(); ++i){
      if(floatList.get(i) > max)
      max = floatList.get(i);
    }
    return max;
  }

  //Minimum
  private static float getMin(List<Float> floatList){
    float min = floatList.get(0);
    for (int i = 0; i < floatList.size(); ++i){
      if(floatList.get(i) < min)
        min = floatList.get(i);
    }
    return min;
  }
  //Interest on total at 20%
  private static float getInterest(List<Float> floatList, Float interest){
    float total = getTotal(floatList);
    float totalWithInt = total * interest;
    return totalWithInt;
  }

  public static void main(String[] args) {

    List<Float> testList = new ArrayList<>();
    int loopCount = 0;
    Scanner scanner = new Scanner(System.in);

      while (testList.size() < 5 && loopCount < 5) {
        try {
          loopCount++;
          System.out.println("There are currently " + testList.size() + " numbers out of 5");
          System.out.println("Please enter in a number for your list.");
          testList.add(scanner.nextFloat());
        } catch (Exception ex) {
          System.out.println("There was an issue with your input: \n" + ex.toString());
          scanner.next();
          System.out.println("We will start you over, ONLY enter NUMBERS.");
          testList = new ArrayList<>();
          loopCount = 0;
        }
      }

    float total = getTotal(testList);
    float interest = getInterest(testList,.20F);
    float totalWithInterest = total + interest;

    System.out.println("The total is: " + total  + ".");
    System.out.println("The average is: " + getAverage(testList) + ".");
    System.out.println("The maximum is: " + getMax(testList) + ".");
    System.out.println("The minimum is: " + getMin(testList) + ".");
    System.out.println("The amount of interest on this amount with a 20% rate is: "
      + interest + ". Which totals out at: " + totalWithInterest + ".");


  }
}
