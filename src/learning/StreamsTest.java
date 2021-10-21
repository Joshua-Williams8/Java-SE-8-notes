package learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsTest {
//  NOTE Java streams use imperative programming vs declarative(Which is what I learned I guess?)


  public static void main(String[] args) {
    List<Person> people = getPeople();

// SIDE   Imperative approach - X Old way!

    List<Person> females = new ArrayList<>();

    for(Person person: people){
      if(person.getGender().equals(Gender.FEMALE)){
        females.add(person);
      }
    }
    females.forEach(System.out::println);
//    Same as SOUT with a for on females to see each female oibject.

// NOTE   Declarative way - New Way! O

//    Filter.

    List<Person> femalesFilter = people.stream()
      .filter(person -> person.getGender().equals(Gender.FEMALE))
      .collect(Collectors.toList());

    femalesFilter.forEach(System.out::println);




  }

  private static List<Person> getPeople() {
    return List.of(
      new Person("Antonio", 20, Gender.MALE),
      new Person("Alina Smith", 33, Gender.FEMALE),
      new Person("Helen White", 57, Gender.FEMALE),
      new Person("Alex Boz", 14, Gender.MALE),
      new Person("Jamie Goa", 99, Gender.MALE),
      new Person("Anna Cook", 7, Gender.FEMALE),
      new Person("Zelda Brown", 120, Gender.FEMALE)
    );
  }
}
