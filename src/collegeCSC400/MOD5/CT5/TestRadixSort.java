package collegeCSC400.MOD5.CT5;

import java.util.Arrays;

public class TestRadixSort {
  public static void main(String[] args) {
    // 783 99 472 182 264 543 356 295 692 491 94


    Integer[] testArrayOne = {2, 5, 3, 0, 2, 3, 0, 3};
    System.out.println("Sorted Array: " + Arrays.toString(RadixSortCT5.radixSort(testArrayOne)) + "\n");

    Integer[] testArrayTwo = {783, 99, 472, 182, 473, 91};
    System.out.println("Sorted Array: " + Arrays.toString(RadixSortCT5.radixSort(testArrayTwo)) + "\n");

    Integer[] testArrayThree = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
    System.out.println("Sorted Array: " + Arrays.toString(RadixSortCT5.radixSort(testArrayThree)) + "\n");

    Integer[] testArrayFour = {783, 99, 472, 182, 1264, 543, 1356, 1356, 295, 692, 491, 1994};
    System.out.println("Sorted Array: " + Arrays.toString(RadixSortCT5.radixSort(testArrayFour)) + "\n");
  }
}
