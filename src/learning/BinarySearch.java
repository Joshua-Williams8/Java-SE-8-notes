package learning;

import java.util.Arrays;

public class BinarySearch {
  //These will return the index of the number is found. -1 if not.
  public static int binarySearchOne(int[] array, int findMe) {
    int low = 0;
    int high = array.length;
    while(low <= high) {
      int mid = (low + high) / 2;
      System.out.println(array[mid]);
      if (findMe == array[mid]) {
        return mid;
      } else if (findMe < array[mid]) {
        high = mid - 1;
        System.out.println("Changed high");
      } else {
        low = mid + 1;
        System.out.println("Changed low");
      }
    }
      return -1;
  }
  public static int binarySearchStrings(String[] array, String findMe) {
//    String.compareTo();
    int low = 0;
    int high = array.length - 1;
    while(low <= high) {
      int mid = (high + low) / 2;
      System.out.println(array[mid]);
      if (findMe.equals(array[mid])) {
        return mid;
//        If findMe comes before the current mid in our array then search the left half
      } else if (findMe.compareToIgnoreCase(array[mid]) < 0) {
        high = mid - 1;
        System.out.println("Searching LEFT Half.");
        System.out.println("Changed high");
        // If not the left side then the right side.
      } else {
        low = mid + 1;
        System.out.println("Searching RIGHT Half.");
        System.out.println("Changed low");
      }
    }
    return -1;
  }

  public static void main(String[] args) {
//    int[] testOne = {0,1,2,3,4,5,6,7};
//    int[] testTwo = {25,56,78,89,90,100,123,414};
//    int testIntOne = binarySearchOne(testOne, 6);
//    int testIntTwo = binarySearchTwo(testOne, 6);
//    System.out.println(testIntTwo);


    String[] testStrings = {"Josh", "Vasantha", "Brian", "Zack", "John", "Michael"};
    Arrays.sort(testStrings);
    System.out.println(Arrays.toString(testStrings));
    int testStringOne = binarySearchStrings(testStrings, "Jon");
    System.out.println(testStringOne);


//    if (testIntOne != -1) {
//      System.out.println("Found it at " + testIntOne);
//    } else {
//      System.out.println("Number was not found.");
//    }

  }
}
