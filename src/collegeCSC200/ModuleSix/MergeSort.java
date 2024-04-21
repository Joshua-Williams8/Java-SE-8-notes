package collegeCSC200.ModuleSix;

// Java program for Merge Sort

class MergeSort {

  // Merges two subarrays of arr[].
  // First subarray is arr[left..m]
  // Second subarray is arr[m+1..r]
  void merge(int arr[], int left, int middle, int right)
  {
    // Find sizes of two subarrays to be merged
    int n1 = middle - left + 1;
    int n2 = right - middle;

    // Create temp arrays
    int leftArr[] = new int[n1];
    int rightArr[] = new int[n2];

    // Copy data to temp arrays
    for (int i = 0; i < n1; ++i)
      leftArr[i] = arr[left + i];
    for (int j = 0; j < n2; ++j)
      rightArr[j] = arr[middle + 1 + j];

    // Merge the temp arrays

    // Initial indices of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = left;
    while (i < n1 && j < n2) {
      if (leftArr[i] <= rightArr[j]) {
        arr[k] = leftArr[i];
        i++;
      }
      else {
        arr[k] = rightArr[j];
        j++;
      }
      k++;
    }

    // Copy remaining elements of leftArr[] if any
    while (i < n1) {
      arr[k] = leftArr[i];
      i++;
      k++;
    }

    // Copy remaining elements of rightArr[] if any
    while (j < n2) {
      arr[k] = rightArr[j];
      j++;
      k++;
    }
  }

  // Main function that sorts arr[left..right] using
  // merge()
  void sort(int arr[], int left, int right)
  {
    if (left < right) {

      // Find the middle point
      int middle = left + (right - left) / 2;

      // Sort first and second halves
      sort(arr, left, middle);
      sort(arr, middle + 1, right);

      // Merge the sorted halves
      merge(arr, left, middle, right);
    }
  }

  // A utility function to print array of size n
  static void printArray(int arr[])
  {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  // Driver code
  public static void main(String args[])
  {
    int arr[] = { 12, 11, 13, 5, 6, 7 };

    System.out.println("Given array is");
    printArray(arr);

    MergeSort ob = new MergeSort();
    ob.sort(arr, 0, arr.length - 1);

    System.out.println("\nSorted array is");
    printArray(arr);
  }
}
/* This code is contributed by Rajat Mishra */
