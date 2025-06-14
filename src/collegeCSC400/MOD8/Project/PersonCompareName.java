package collegeCSC400.MOD8.Project;

import java.util.Comparator;

public class PersonCompareName implements Comparator<Person> {
  public int compare(Person pa, Person pb) {
    return pb.getLastName().compareTo(pa.getLastName());
  }
}
