package collegeCSC200.ModuleSix;



// Java program for implementation of Insertion Sort
public class InsertionSort {
  /*Function to sort array using insertion sort*/
  void sort(int arr[])
  {
    int n = arr.length;
    for (int i = 1; i < n; ++i) {
      int key = arr[i];
      int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
      while (j >= 0 && arr[j] > key) {
        System.out.println(" BEFORE while compareIndex = " + j + " and currentNum = " + key);
        arr[j + 1] = arr[j];
        j = j - 1;
        System.out.println(" AFTER while compareIndex = " + j + " and currentNum = " + key);
        printArray(arr);
      }
      arr[j + 1] = key;
      System.out.println("The currentNum is " + key);
      System.out.println("The current index is " + i);
      System.out.print("Our Array before next for loop is ");
      printArray(arr);
    }
  }

  /* A utility function to print array of size n*/
  static void printArray(int arr[])
  {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");

    System.out.println();
  }

  // Driver method
  public static void main(String args[])
  {
    int arr[] = { 12, 11, 13, 5, 6 };
    System.out.println("Start of array list");
    printArray(arr);

    InsertionSort ob = new InsertionSort();
    ob.sort(arr);

    printArray(arr);
  }
}
