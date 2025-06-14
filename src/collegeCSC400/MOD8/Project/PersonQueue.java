package collegeCSC400.MOD8.Project;

import java.util.ArrayList;
import java.util.Comparator;

public class PersonQueue {

  private ArrayList<Person> people = new ArrayList<>();

  public void enqueue(Person p) {
    people.add(p);
  }

  public Person getFront() {
    return people.get(0);
  }

  public Boolean isEmpty() {
    return people.isEmpty();
  }

  public Person dequeue() {
    if (isEmpty()) {
      System.out.println("This queue is empty, no one to dequeue");
      return null;
    }
    return people.remove(0);
  }

  public void clear() {
    people =  new ArrayList<>();
  }

  public int count() {
    return people.size();
  }

  public void sortByLastName() {
    PersonCompareName compare = new PersonCompareName();
    mergeSortPerson(people, compare);
  }

  public void sortByAge() {
    PersonCompareAge compare = new PersonCompareAge();
    mergeSortPerson(people, compare);
  }

  public void printQueue() {
    for(Person p : people) {
      System.out.println(p.getFirstName() + " " + p.getLastName() + " " + p.getAge());
    }
  }

  private static void mergeSortPerson(ArrayList<Person> list, Comparator customCompare) {
    if (list.size() <= 1) {
      return;
    }

    int mid = list.size()/2;

    ArrayList<Person> leftStrings = new ArrayList<>(list.subList(0, mid));
    ArrayList<Person> rightStrings = new ArrayList<>(list.subList(mid, list.size()));

    mergeSortPerson(leftStrings, customCompare);
    mergeSortPerson(rightStrings, customCompare);

    mergePersonLists(list, leftStrings, rightStrings, customCompare);

  }

  //Takes in the original list to sort, and both a right side and left side list to check
  // Lastly takes in the comparator, in case it needs to be changed for later.
  // This method goes through each list, and compares all the left/right lists elements
  // The element that is less than the other is added to the mainList at the lowest position
  //going up until the last element is added to the end.

  //This method changes the actual list, so it does not need to be returned
  //It will continue to be called until all left and right list have been added into the array
  private static void mergePersonLists(ArrayList<Person> mainList, ArrayList<Person> leftSide, ArrayList<Person> rightSide, Comparator customCompare) {

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
