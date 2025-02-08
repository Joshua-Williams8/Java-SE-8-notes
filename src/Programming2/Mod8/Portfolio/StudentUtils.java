package Programming2.Mod8.Portfolio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//Utilities class for holding methods related to students for portfolio
//Separating it helps clean up my driver class of extra code.
public class StudentUtils {

  public static Double getValidDouble(String prompt) {
    //We want to go ahead and get a string instead of calling nextDouble.
    String testOutput = getValidString(prompt);
    Double output = null;
    //Now we want to parse that string into a double, and make sure it is valid.
    try {
      output = Double.parseDouble(testOutput);
      //If invalid call out method again.
    } catch (Exception ex) {
      System.out.println("There was an issue with your input try again.");
      //Call the method again if the input is bad.
      return getValidDouble(prompt);
    }
    return output;
  }

  public static String getValidString(String prompt) {
    Scanner scanner = new Scanner(System.in);

    System.out.println(prompt);
    //Will catch if improper input is given.
    String output = null;
    try {
      output = scanner.nextLine();
    } catch (Exception ex) {
      System.out.println("There was an issue with your input try again.");
      scanner.next();
      //Call the method again if the input is bad.
      return getValidString(prompt);
    }
    return output;
  }

  //Re-used code from my programming 1 class.
  public static void writeStudentsToFile (ArrayList<Student> list) {

    StringBuilder studentList = new StringBuilder();
    for (Student stu : list){
      studentList.append(stu.toString());
    }

    try {
      //Note: the path is for my MAC, you will need to edit this depending on your own path.
      File newTextFile = new File(File.separator + "tmp" + File.separator + "Students.txt");

      FileWriter fw = new FileWriter(newTextFile);
      fw.write(studentList.toString());
      fw.close();

    } catch (IOException ex) {
      System.out.println("There was an issue printing the file: \n" + ex.toString());
    }
  }


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
}
