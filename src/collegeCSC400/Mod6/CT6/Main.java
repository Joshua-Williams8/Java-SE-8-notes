package collegeCSC400.Mod6.CT6;

import java.util.Iterator;

public class Main {
  //Test Inserting nodes using the copied code from the assignment
  public static void testInsert(){
    CustomLinkedList linkedList = new CustomLinkedList();

    //Initial Test for insert
    // Insert some elements
    linkedList.insert(1);
    linkedList.insert(2);
    linkedList.insert(3);

    // Iterate and display elements
    Iterator<Integer> iterator = linkedList.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    // displays 1 2 3
  }
  //Test delete and test Iterate
  public static void testDelete(){
    CustomLinkedList linkedList = new CustomLinkedList();
    //NOTE: testing delete once insert confirmed to work.
    linkedList.insert(1);
    linkedList.insert(2);
    linkedList.insert(3);
    linkedList.insert(2);

    linkedList.delete(2);

    //Displays 1 3 2
    //Testing iterate
    linkedList.iterate();
  }
  public static void testInsertFromFile() {
    CustomLinkedList linkedList = new CustomLinkedList();
    linkedList.insertFromTextFile("AddTheseNodes.txt");
    linkedList.iterate();
  }
  public static void main(String[] args) {
    System.out.println("Testing Insert using original code");
    testInsert();
    System.out.println("\nTest insert end");

    System.out.println("Testing delete using iterate method to go over values");
    testDelete();
    System.out.println("Test Delete End");

    System.out.println("Testing insertFromFile");
    //NOTE: AddTheseNodes File needs to be located in Tmp folder
    testInsertFromFile();
    System.out.println("Testing insertFromFile End");





  }
}
