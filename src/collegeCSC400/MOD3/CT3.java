package collegeCSC400.MOD3;

import java.util.HashSet;

public class CT3 {
  public static int findValue(int[] ints) {
    HashSet intsSet = new HashSet();
    int min = ints[0];

    for (int num: ints) {
      intsSet.add(num);
      if (min > num ) {
        min = num;
      }
    }

    for (int i = 0; i <= ints.length; i++) {
      if (!intsSet.contains(min)) {
        return min;
      }
      else {
        min++;
      }
    }
    //If we are given an array without a gap
    //We should return a safe value (we do not have one)
    return 0;
  }

  public static void main(String[] args) {
    int[] testArray = new int[5];
    testArray[0] = 5;
    testArray[1] = 8;
    testArray[2] = 3;
    testArray[3] = 7;
    testArray[4] = 4;

    //This should return 6
    System.out.println(findValue(testArray));
  }
}
