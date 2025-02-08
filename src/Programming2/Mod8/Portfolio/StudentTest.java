package Programming2.Mod8.Portfolio;

import java.util.ArrayList;
import java.util.Scanner;

import static Programming2.Mod8.Portfolio.StudentUtils.*;


public class StudentTest {

  public static Scanner scanner = new Scanner(System.in);

  //Refactored code from Mod 5 from recursion to use a loop
  /*
  list - the list that will have student added to it
  totalAmount - the amount of students the list should have at the end
  Used two other methods to collect different types of data.
   */
  public static void addStudentsToList(ArrayList<Student> list, int maxAmount) {

    while(list.size() < maxAmount) {

      System.out.println("Put enter Student " + (list.size() + 1) + " information:");
      System.out.println("If you are done adding students please enter an x (uppercase or lowercase) in the name field to stop adding students.");
      String fullName = getValidString("Please enter the student's full name.");
      if (fullName.equalsIgnoreCase("X")) {
        break;
      }
      String fullAddress = getValidString("Please enter the student's street address.");
      Double gpa = getValidDouble("Please enter the student's GPA.");
      list.add(new Student(fullName, fullAddress, gpa));
    }
  }



  public static void main(String[] args) {
    ArrayList<Student> students = new ArrayList<>();
    addStudentsToList(students, 10);
    mergeSortStudents(students, new StudentNameCompare());
    //File located at: tmp/Students.txt
    writeStudentsToFile(students);

  }

}
