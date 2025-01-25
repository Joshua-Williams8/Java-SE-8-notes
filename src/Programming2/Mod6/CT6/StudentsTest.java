package Programming2.Mod6.CT6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
//import java.util.Collections;

public class StudentsTest {

//      Student student1 = new Student(1,"Abe","10 Bear Drive");
//    Student student2 = new Student(1,"Brandon","9 Bear Drive");
//    Student student3 = new Student(1,"Charlie","8 Bear Drive");
//    Student student4 = new Student(1,"Deacon","7 Bear Drive");
//    Student student5 = new Student(1,"Edward","6 Bear Drive");
//    Student student6 = new Student(1,"Foster","5 Bear Drive");
//    Student student7 = new Student(1,"Gary","4 Bear Drive");
//    Student student8 = new Student(1,"Harriet","3 Bear Drive");
//    Student student9 = new Student(1,"Ita","2 Bear Drive");
//    Student student10 = new Student(1,"Jake","1 Bear Drive");

  //Left the compare customizable in case I decided to swap options, or need it for later.

  public static void mergeSortStudents(ArrayList<Student> list, Comparator customCompare) {
    if (list.size() <= 1) {
      return;
    }

    int mid = list.size()/2;
//    System.out.println(mid);

    ArrayList<Student> leftStudents = new ArrayList<>(list.subList(0, mid));
//    System.out.println("Left: " + leftStudents.get(mid - 1));
    ArrayList<Student> rightStudents = new ArrayList<>(list.subList(mid, list.size()));
//    System.out.println("Right: " + rightStudents.get(0));
    //list.size() refers to the index in subList, not the actual size of the subList.
//    System.out.println(leftStudents.size());
//    System.out.println(rightStudents.size());
//    System.out.println(list.size());

    mergeSortStudents(leftStudents, customCompare);
    mergeSortStudents(rightStudents, customCompare);
//
    mergeStudentLists(list, leftStudents, rightStudents, customCompare);

  }

  public static void mergeStudentLists(ArrayList<Student> mainList, ArrayList<Student> leftSide, ArrayList<Student> rightSide, Comparator customCompare) {

    int m = 0;
    int l = 0;
    int r = 0;

    int compareValue = customCompare.compare(leftSide.get(l), rightSide.get(r));
//    System.out.println("Compare Value: " + compareValue);
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



    // For testing end result of comparator
//    Collections.sort(studentList, new StudentRollnoCompare());
    System.out.println("___________");
    for (Student stu: studentList){
      System.out.println(stu.toString());
    }
  }


}
