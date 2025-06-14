package collegeCSC400.MOD7;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Dicussion {

  public static void mergeSortStrings(ArrayList<String> list, Comparator customCompare) {
    if (list.size() <= 1) {
      return;
    }

    int mid = list.size()/2;

    ArrayList<String> leftStrings = new ArrayList<>(list.subList(0, mid));
    ArrayList<String> rightStrings = new ArrayList<>(list.subList(mid, list.size()));

    mergeSortStrings(leftStrings, customCompare);
    mergeSortStrings(rightStrings, customCompare);

    mergeStringLists(list, leftStrings, rightStrings, customCompare);

  }

  //Takes in the original list to sort, and both a right side and left side list to check
  // Lastly takes in the comparator, in case it needs to be changed for later.
  // This method goes through each list, and compares all the left/right lists elements
  // The element that is less than the other is added to the mainList at the lowest position
  //going up until the last element is added to the end.

  //This method changes the actual list, so it does not need to be returned
  //It will continue to be called until all left and right list have been added into the array
  public static void mergeStringLists(ArrayList<String> mainList, ArrayList<String> leftSide, ArrayList<String> rightSide, Comparator customCompare) {

    int m = 0;
    int l = 0;
    int r = 0;

    //This value will be -1 0 or 1, depending on if l is less than equal to or greater than r
    int compareValue = customCompare.compare(leftSide.get(l), rightSide.get(r));
    //Do the same thing for both -1 and 0
    //If the left side is less than the right
    while(l < leftSide.size() && r < rightSide.size() && m < mainList.size()) {
      compareValue = customCompare.compare(leftSide.get(l), rightSide.get(r));
      if (compareValue <= 0) {
        mainList.set(m , leftSide.get(l));
        m++;
        l++;
        //If the value is 1 then the right side gets put in.
      } else {
        mainList.set(m , rightSide.get(r));
        m++;
        r++;
      }
    }

    //Add in the remaining values to which ever side still has values
    while(l < leftSide.size()) {
      mainList.set(m , leftSide.get(l));
      m++;
      l++;
    }

    while(r < rightSide.size()) {
      mainList.set(m , rightSide.get(r));
      m++;
      r++;
    }

  }

  public static void main(String[] args) {
    ArrayList<String> testStrings = new ArrayList<>();
    testStrings.add("Faun");
    testStrings.add("Mike");
    testStrings.add("Brice");

    System.out.println(Arrays.toString(testStrings.toArray()));
    //prints [Faun, Mike, Brice]
    mergeSortStrings(testStrings, new StringCompare());
    System.out.println(Arrays.toString(testStrings.toArray()));
    //prints [Brice, Faun, Mike]


  }


}
class StringCompare implements Comparator<String> {
  public int compare(String s1, String s2) {
    return s1.compareToIgnoreCase(s2);
  }
}
