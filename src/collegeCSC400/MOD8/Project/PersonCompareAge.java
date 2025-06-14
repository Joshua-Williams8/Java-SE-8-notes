package collegeCSC400.MOD8.Project;

import java.util.Comparator;

public class PersonCompareAge implements Comparator<Person> {
  public int compare(Person pa, Person pb) {
    return pb.getAge().compareTo(pa.getAge());
  }
}
