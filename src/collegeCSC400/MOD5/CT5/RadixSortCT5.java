package collegeCSC400.MOD5.CT5;

import java.util.Arrays;

public class RadixSortCT5 {
  //Implement the radix sort algorithm in Java.
  // Analyze your algorithm in Big-Oh notation and
  // provide the appropriate analysis.
  //Analyze the algorithm by documenting the steps taken when radix sort
  // sorts the following array of Integer objects:
  // 783 99 472 182 264 543 356 295 692 491 94
  //Analyze the Big-O of your algorithm.

  //NOTE: Count sort setup:
  //Find Max just gets the highest number in the array given.
  public static Integer findMax(Integer[] nums) {
    Integer max = nums[0];
    for(Integer num: nums) {
      if (max < num) {
        max = num;
      }
    }
    return max;
  }

  //countSort for RadixSort
  public static Integer[] countSort(Integer[] nums, int exponential) {

    int length = nums.length;
    //No more max needed here

    //An array for every number in the array to count.
    //Now only needs to hold 10 since we are working with only 0 through 9
    Integer[] countArray = new Integer[10];
    Arrays.fill(countArray, 0);
//    System.out.println(Arrays.toString(nums));
    //We want to increment that count for each number
    for(Integer num: nums ) {
      //We need to take the current exponential and divide the number by that
      // then modulo it by 10,
      // to get the digit we want
      //Example 523 % 10 on it's own is 3
      // and 523 % 100 is 23
      // , we want just the 2, so 523 / 10 = 52.3,
      // without a decimal is 52, now % 10 is 2.
      //NOTE: This change was also made in the for loop for placements output
      countArray[(num / exponential) % 10] = countArray[(num / exponential) % 10] + 1;
    }
//    System.out.println(Arrays.toString(countArray));
    //Start at 1 because we are getting a cumulative sum
    for (int i = 1; i < countArray.length; i++ ) {
      countArray[i] = countArray[i-1] + countArray[i];
    }
//    System.out.println(Arrays.toString(countArray));

    //for storing out out values
    Integer[] output = new Integer[length];

    //Now we want to work backwards
    for (int i = output.length - 1; i >= 0; i-- ) {
      Integer currentNum = nums[i];
      Integer currentCountLocation = countArray[(currentNum / exponential) % 10] - 1 ;
      //Don't forget to update the countArray
      countArray[(currentNum / exponential) % 10] = countArray[(currentNum / exponential) % 10] - 1;
      //This part below doesn't change
      output[currentCountLocation] = currentNum;
    }

    return output;
  }

  public static Integer[] radixSort(Integer[] inputNums ) {
    System.out.println("Original Array: " + Arrays.toString(inputNums));
    Integer max = findMax(inputNums);
    //Need to make a copy since we want to return an array rather than make this void
    Integer[] copyInput = new Integer[inputNums.length];
    for(int i = 0; i < copyInput.length; i++) {
      copyInput[i] = inputNums[i];
    }
      //
    for(int i = 1; max/i > 0; i = i * 10) {
      copyInput = countSort(copyInput, i);
    }
    return copyInput;
  }

  //For Radix
  //Big Oh
  //n for the max
  //d for the loop amount for max amount of digits, ex 459, would be 3?
  //inside the d loop, we run through an n loop 3 times.
  // n + d(n + n + 10)
  //n + d(2n + 10)
  //n + 2dn + 10d
  //2dn + n + 10d

}
