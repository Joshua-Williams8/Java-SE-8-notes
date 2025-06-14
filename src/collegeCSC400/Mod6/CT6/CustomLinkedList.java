package collegeCSC400.Mod6.CT6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CustomLinkedList {
  private Node head;

  // Other methods...

  public Iterator<Integer> iterator() {
    return new LinkedListIterator();
  }

  private class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private class LinkedListIterator implements Iterator<Integer> {
    private Node current = head;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Integer next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      int data = current.data;
      current = current.next;
      return data;
    }
  }


  // Other methods...

  //insert(int data): Inserts a new node with the given data.
  public void insert(int data) {
    //We also need a case if head is null to get started
    if (head == null) {
      head = new Node(data);
//      System.out.println(head.data);
    } else {
      //We need to start at the head, and go down until we find the end with a null value
      Node lastNode = head;
      //We want to check if the next value is null, if it is not, move on to the next node.
      while (lastNode.next != null) {
        lastNode = lastNode.next;
      }
      //Once we are out of the while loop define that next value
      lastNode.next = new Node(data);
//      System.out.println(lastNode.next.data);
    }
  }

  //delete(int data): Deletes the first occurrence of a node with the given data.
  public void delete(int data) {
    //Check if the head is null
    if (head == null) {
      //Just get out of the function if the head is null.
      return;
      //Check if the head is the value
    } else if (head.data == data) {
//        If it is the value, just redefine the actual head to head.next
      head = head.next;
      return;
    } else {
      //Same idea as before go through the nodes, except we are searching for a value.
      Node currentNode = head;
      //We want to check if the next value is null, if it is not, check the value
      while (currentNode.next != null) {
        //If the node with the value is found, we want to just
        // redefine over the next to the next.next
        if (currentNode.next.data == data) {
          //Before that we have to check if the next.next has a node there already.
          //If the next next value is null
          //If it is null, then just remove the .next and return.
          if (currentNode.next.next == null) {
            currentNode.next = null;
            return;
          } else {
            //Make the .next the next next node over.
            currentNode.next = currentNode.next.next;
            //Once found end the function
            return;
          }
          //We shouldn't make it here at all
        }
        //move on to the next node continue while loop.
        currentNode = currentNode.next;
      }
    }
  }

  //iterate(): Returns an iterator for traversing the linked list.
  public void iterate() {
    Iterator<Integer> iterator = iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.print("\n");
  }

  //insertFromTextFile(String filePath)
  //Inserts node data from a text file inside the tmp folder
  //Reused some code I had from a different program that needed to read from a file
  public void insertFromTextFile(String fileName) {
    try {
      File expressions = new File(File.separator + "tmp" + File.separator + fileName);
      Scanner scanner = new Scanner(expressions);
      //Suggestions - check if the file is empty.
      if (!scanner.hasNextLine()) {
        System.out.println("You file is empty!");
        return;
      }
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
//        System.out.println(line);
        this.insert(Integer.parseInt(line));
      }
      scanner.close();
      //Suggestions - Check if the file cannot be found.
    } catch (FileNotFoundException e) {
      System.out.println("The file could not be found!");
    } catch (Exception e) {
      System.out.println("There was and with your file!");
      e.printStackTrace();
    }
  }
}
