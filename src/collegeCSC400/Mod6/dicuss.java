package collegeCSC400.Mod6;

import java.util.Arrays;

public class dicuss {

  public static Integer findMax(Integer[] nums) {
    Integer max = nums[0];
    for(Integer num: nums) {
      if (max < num) {
        max = num;
      }
    }
    return max;
  }

  //countSort
  public static Integer[] countSort(Integer[] nums) {
    int length = nums.length;
    Integer max = findMax(nums);
    //An array for every number in the array to count.
    Integer[] countArray = new Integer[max+1];
    Arrays.fill(countArray, 0);
    System.out.println(Arrays.toString(nums));
    //We want to increment that count for each number
    for(Integer num: nums ) {
      countArray[num] = countArray[num] + 1;
    }
    //Start at 1 because we are getting a cumulative sum
    for (int i = 1; i < countArray.length; i++ ) {
      countArray[i] = countArray[i-1] + countArray[i];
    }
    //for storing out out values
    Integer[] output = new Integer[length];
    //Now we want to work backwards
    for (int i = output.length - 1; i >= 0; i-- ) {
      Integer currentNum = nums[i];
      Integer currentCountLocation = countArray[currentNum] - 1 ;
      //Don't forget to update the countArray
      countArray[currentNum] = countArray[currentNum] - 1;
      output[currentCountLocation] = currentNum;
    }
    return output;
  }
  public static void main(String[] args) {
    Integer[] testArray = {1, 6, 3, 0, 1, 3, 0, 3};
    System.out.println(Arrays.toString(countSort(testArray)));
    //Returns [0, 0, 1, 1, 3, 3, 3, 6]
  }
}
