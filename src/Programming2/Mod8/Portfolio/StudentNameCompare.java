package Programming2.Mod8.Portfolio;

import java.util.Comparator;

//This method compares each student's name
//If s1 comes before than s2, it will return -1,
// if they are the same name 0,
// s2 comes before s1 then 1.
public class StudentNameCompare implements Comparator<Student> {
  public int compare(Student s1, Student s2){
    return s1.getName().compareToIgnoreCase(s2.getName());
  }
}
