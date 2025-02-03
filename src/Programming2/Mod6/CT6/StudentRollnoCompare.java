package Programming2.Mod6.CT6;

import java.util.*;

//This method compares each student's rollno
//If s1 is less than s2, it will return -1, if it is the same 0, if it is greater then 1.
public class StudentRollnoCompare implements Comparator<Student> {
  public int compare(Student s1, Student s2){
    return Integer.compare(s1.getRollno(), s2.getRollno());
  }
}
