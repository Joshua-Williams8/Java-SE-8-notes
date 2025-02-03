package Programming2.Mod6.CT6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//Driver class
public class StudentsTest {

  //This method takes the arrayList and breaks it down into smaller bites,
  // until each list only has one element.
public static void mergeSortStudents(ArrayList<Student> list, Comparator customCompare) {
    if (list.size() <= 1) {
      return;
    }

    int mid = list.size()/2;

    ArrayList<Student> leftStudents = new ArrayList<>(list.subList(0, mid));
    ArrayList<Student> rightStudents = new ArrayList<>(list.subList(mid, list.size()));

    mergeSortStudents(leftStudents, customCompare);
    mergeSortStudents(rightStudents, customCompare);

    mergeStudentLists(list, leftStudents, rightStudents, customCompare);

  }

  //Takes in the original list to sort, and both a right side and left side list to check
  // Lastly takes in the comparator, in case it needs to be changed for later.
  // This method goes through each list, and compares all the left/right lists elements
  // The element that is less than the other is added to the mainList at the lowest position
  //going up until the last element is added to the end.

  //This method changes the actual list, so it does not need to be returned
  //It will continue to be called until all left and right list have been added into the array
  public static void mergeStudentLists(ArrayList<Student> mainList, ArrayList<Student> leftSide, ArrayList<Student> rightSide, Comparator customCompare) {

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
    ArrayList<Student> studentList = new ArrayList<>(Arrays.asList(
      new Student(2,"Brandon","9 Bear Drive"),
      new Student(4,"Deacon","7 Bear Drive"),
      new Student(6,"Foster","5 Bear Drive"),
      new Student(7,"Gary","4 Bear Drive"),
      new Student(9,"Ita","2 Bear Drive"),

      new Student(1,"Abe","10 Bear Drive"),
      new Student(8,"Harriet","3 Bear Drive"),
      new Student(10,"Jake","1 Bear Drive"),
      new Student(5,"Edward","6 Bear Drive"),
      new Student(3,"Charlie","8 Bear Drive")
    ));

    for (Student stu: studentList){
      System.out.println(stu.toString());
    }

    mergeSortStudents(studentList, new StudentRollnoCompare());

    System.out.println("___________");
    for (Student stu: studentList){
      System.out.println(stu.toString());
    }
  }
}
