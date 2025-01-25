package Programming2.Mod6.CT6;

import java.util.*;

public class StudentRollnoCompare implements Comparator<Student> {
  public int compare(Student s1, Student s2){
    System.out.println("s1: " + s1.rollno);
    System.out.println("s2: " + s2.rollno);
    return s1.rollno.compareTo(s2.rollno);
  }
}
