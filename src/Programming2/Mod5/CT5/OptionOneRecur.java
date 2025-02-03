package Programming2.Mod5.CT5;

import java.util.ArrayList;
import java.util.Scanner;

public class OptionOneRecur {

  public static Scanner scanner = new Scanner(System.in);

  //Will continue to ask for numbers until the list has 5 values
  public static void fillArrayToFive(ArrayList<Long> list) {
    if (list.size() < 5) {
      System.out.println("Please enter a number");
      //Will catch any exceptions thrown for entering in letters or incorrect number types.
      try {
        list.add(scanner.nextLong());
        fillArrayToFive(list);
      } catch (Exception ex) {
        System.out.println("There was an issue with your input try again.");
        scanner.next();
        fillArrayToFive(list);
      }
    }
  }

  //Will remove numbers from the list until there is only one left, then will give the value back.
  //This method can be used an initial call.
  public static Long recursionProduct(ArrayList<Long> list) {
    //Check for special list sizes, like 2, 1 and 0.
    if (list.size() == 2) {
      return list.get(0) * list.get(1);
    } else if (list.size() == 1) {
      return list.get(0);
    } else if (list.size() == 0) {
      return null;
    }
    Long product = list.get(0) * list.get(1);

    //Go up to 2 since we already did the first group?
    return recursionProduct(list, 2, product);
  }

  public static Long recursionProduct(ArrayList<Long> list, int currIndex, Long currProduct) {
    //Check for special list sizes, like 2, 1 and 0.
    if (list.size() == 2) {
      return list.get(0) * list.get(1);
    } else if (list.size() == 1) {
      return list.get(0);
    } else if (list.size() == 0) {
      return null;
    }
    currProduct = currProduct * list.get(currIndex);
    currIndex++;
    //If after getting the new product we are at the end, return the product
    if (currIndex >= list.size()) {
      return currProduct;
    }

    return recursionProduct(list, currIndex, currProduct);
  }


  public static void programForRecursion() {
    ArrayList<Long> inputs = new ArrayList<>();
    fillArrayToFive(inputs);
    //Calling it directly in the line
//    System.out.println("The product of all 5 numbers is: " + recursionProduct(inputs));
    System.out.println("The product of all 5 numbers is: " + recursionProduct(inputs, 0, 1L));

  }

  public static void main(String[] args) {
    programForRecursion();
  }
}
