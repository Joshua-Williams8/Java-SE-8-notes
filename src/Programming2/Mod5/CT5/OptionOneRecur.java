package Programming2.Mod5.CT5;

import java.util.ArrayList;
import java.util.Scanner;

public class OptionOneRecur {

  public static Scanner scanner = new Scanner(System.in);

  //Will continue to ask for numbers until the list has 5 values
  public static void fillArrayToFive(ArrayList<Long> list) {
    if (list.size() < 5) {
      System.out.println("Please enter a number");
      list.add(scanner.nextLong());
      fillArrayToFive(list);
    }
  }

  //Will remove numbers from the list until there is only one left, then will give the value back.
  public static Long recursionProduct(ArrayList<Long> list){
    list.set(1, list.get(0) * list.get(1));
    list.remove(0);
    if(list.size() == 1) {
      return list.get(0);
    }
    return recursionProduct(list);
  }

  public static void programForRecursion() {
    ArrayList<Long> inputs = new ArrayList<>();
    fillArrayToFive(inputs);
    //Calling it directly in the line
    System.out.println("The product of all 5 numbers is: " + recursionProduct(inputs));

//Replaced with recursive method
//    while (inputs.size() < 5) {
//    System.out.println("Please enter a number");
//    inputs.add(scanner.nextLong());
//    }
  }

  public static void main(String[] args) {
    programForRecursion();
  }
}
