package collegeCSC400.MOD8.Project;

import java.util.Scanner;

public class QueueTest {
  public static void addPeopleToQueue(PersonQueue personQueue) {
    Scanner scanner = new Scanner(System.in);
    int amount = getAnInt("How many people would you like to add to this queue?");

    int count = 0;
    while(amount > count) {
      System.out.println("Current amount for in queue: " + personQueue.count());
      String firstName;
      String lastName;
      Short age;

      System.out.println("What is this person's first name?");
      firstName = scanner.nextLine();
      System.out.println("What is this person's last name?");
      lastName = scanner.nextLine();

      age = getAShort("How old is this person?");

      personQueue.enqueue(new Person(firstName, lastName, age));
      count++;
      continue;
    }
  }


  public static int getAnInt(String prompt) {
    Scanner scanner = new Scanner(System.in);
    int num;
    System.out.println(prompt);
    try {
      num = scanner.nextInt();
      scanner.nextLine();
      return num;
    } catch (Exception e) {
      System.out.println("You did not give a proper input, please try again.");
      return getAnInt(prompt);
    }
  }

  public static short getAShort(String prompt) {
    Scanner scanner = new Scanner(System.in);
    short num;
    System.out.println(prompt);
    try {
      num = scanner.nextShort();
      scanner.nextLine();
      return num;
    } catch (Exception e) {
      System.out.println("You did not give a valid input, please try again.");
      return getAShort(prompt);
    }
  }

  public static void main(String[] args) {
    PersonQueue lineOfPeople = new PersonQueue();

    addPeopleToQueue(lineOfPeople);
    lineOfPeople.printQueue();

    System.out.println("Sorting list by Age Descending (Oldest to youngest)");
    lineOfPeople.sortByAge();
    lineOfPeople.printQueue();

    System.out.println("Sorting list by Last Name Descending (Z to A)");
    lineOfPeople.sortByLastName();
    lineOfPeople.printQueue();



  }
}
