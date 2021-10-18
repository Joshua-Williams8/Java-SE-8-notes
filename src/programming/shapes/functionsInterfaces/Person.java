package programming.shapes.functionsInterfaces;

import java.util.ArrayList;
import java.util.List;

public class Person {
  //Above is a class used to create Objects.
  //Below are all the fields (properties and methods), for said objects.

  public String name;// This is a property, each Person object has a name property.


  public Person(String name) { //This is a constructor method, it has the same name as the class, but it's for when you create a Person Object, to go ahead and give certain properties values, in this case just the name.
    this.name = name;
  }


  public String getName() { //This is a method for the Person objects, where it gets the name property
//TODO: return the person's name
    return this.name;
  }

  public void setName(String name) {
//TODO: change the name property to the passed value
    this.name = name;
  }

  public void sayHello() {
//TODO: print a message to the console using the person's name
    System.out.printf("Hello %s\n", this.name);
  }

//  public static Person[] addPerson(Person[] pArray, Person pObject){
//    Person[] result = Arrays.copyOf(pArray, pArray.length + 1);
//    result[pArray.length + 1] = pObject;
//    return result;
//  }

  public static void main(String[] args) {
//    Person josh = new Person("NotJosh"); //this is an object created using the class Person.
//    System.out.println(josh.getName());
//    josh.setName("Josh");
//    josh.sayHello();


    //Code block 1 output should be True, then false? This is a guess.
//    Person person1 = new Person("John");
//    Person person2 = new Person("John");
//    System.out.println(person1.getName().equals(person2.getName()));
//    System.out.println(person1 == person2); //These are 2 different JAva IDs?
    //I was correct

    //Code block 2 output should be false?

//    Person person1 = new Person("John");
//    Person person2 = person1;
//    System.out.println(person1 == person2);// These are the same ID cause we are copying person1?
////I was wrong oof.
//    System.out.println(person2);
//    System.out.println(person1);

    //Code block 3 output should be "John", then null?, then "John, and lastly "Jane"
//    Person person1 = new Person("John");
//    Person person2 = person1; //Takes all of the properties and now their the same.
//    System.out.println(person1.getName());
//    System.out.println(person2.getName());
//    person2.setName("Jane");
//    System.out.println(person1.getName()); //Not sure why person1 got changed unless both are referencing the same data? like how they share ids.
//    System.out.println(person2.getName());


//    NOTE New stuff for stream notes down here mate

    List<Person> people = new ArrayList<>();
    people.add(new Person("josh"));
    people.add(new Person("travas"));
    people.add(new Person("lucas"));
    people.add(new Person("john"));
    people.add(new Person("joe"));
    people.add(new Person("trayvon"));

    people.stream()
      .filter(person -> person.getName().contains("j"))
//      .peek(person -> System.out.println(person.getName()))
      .findFirst();




  }
}
