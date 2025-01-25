package Programming2.Mod6.CT6;

import java.util.*;

public class StudentRollnoCompare implements Comparator<Student> {
  public int compare(Student s1, Student s2){
    return s1.rollno.compareTo(s2.rollno);
  }
}
