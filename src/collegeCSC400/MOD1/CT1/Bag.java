package collegeCSC400.MOD1.CT1;

import java.util.HashMap;
import java.util.Set;

public class Bag<T> {
//I chose to use a HashMap to hold my items, because it can hold two values or key value pairs
//The key will be the item - T
//The value with the count of the item so far. - Integer
  private HashMap<T, Integer> items = new HashMap<>();

//Basic constructor
  public Bag() {
  }

//  void add(T item)`:
//  This method should add an item of type T to the bag.
  /*
  add takes in T item
  if that item is already in our hashmap, it will add one to the count
  if that item if not in our hashmap/bag, it will remove that item.
   */
  public void add(T item) {
    if(contains(item)) {
      items.put(item, items.get(item) + 1 );
    } else {
      items.put(item, 1);
    }
  }
//`void remove(T item)`:
// This method should remove one occurrence of the item from the bag, if it exists.
  /*
  remove takes in T item
  if that item is in our hashmap, we will then check how many there are
  if there the count is larger than 1, we will only remove one item from the count.
  if there is only 1 of that item, then we will remove it from our hashmap/bag
  */
  public void remove(T item) {
    if(contains(item)) {
      if(items.get(item) > 1) {
        items.put(item, items.get(item) - 1);
      } else if (items.get(item) == 1) {
        items.remove(item);
      }
    }
  }
// `boolean contains(T item)`:
// This method should return true if the item exists in the bag;
// otherwise, it should return false.
  /*
  contains takes in T item
  checks if that key is in our hashmap, and true or false if so
  */
  public boolean contains(T item){
    return items.containsKey(item);
  }

  /*
  count takes in T item
  checks if that key is in our hashmap
  if the item is in our hashmap, it will return the count
  if the item is not, then it will return 0
  */
  public Integer count(T item) {
    if(contains(item)) {
      return items.get(item);
    } else {
      return 0;
    }
  }

  /*
  getBagItems returns a Set<T> of keys or items currently in our bag.
  */
  public Set<T> getBagItems() {
    return items.keySet();
  }

  public static void main(String[] args) {

//    Create an instance of the `Bag` class.
    Bag bag = new Bag();

//Add several elements to the bag, including duplicates.
    bag.add("two");
    bag.add("two");
    bag.add(3);
    bag.add("one");
    bag.add(3);
    bag.add(3);
    bag.add(4.2);
    bag.add(4.2);
    bag.add(4.2);
    bag.add(4.2);

//Print the bag contents.
    for (Object item : bag.getBagItems()) {
      System.out.println(item + "\ncount: " + bag.count(item));
    }
//Test the `contains` method for a few elements.
    System.out.println("The bag contains the string two?\n" + bag.contains("two"));
    System.out.println("The bag contains the string one?\n" + bag.contains("one"));
    System.out.println("The bag contains the integer 3?\n" + bag.contains(3));
    System.out.println("The bag contains the integer 4?\n" + bag.contains(4));
//Test the `count` method for a few elements.
    System.out.println("The bag has this many two entries:\n" + bag.count("two"));
    System.out.println("The bag has this many one entries:\n" + bag.count("one"));
    System.out.println("The bag has this many 3 entries:\n" + bag.count(3));
    System.out.println("The bag has this many 4 entries:\n" + bag.count(4));
//Remove an element from the bag.
    bag.remove("one");
//Print the bag contents again
    for (Object item : bag.getBagItems()) {
      System.out.println(item + "\ncount: " + bag.count(item));
    }
//Test the `contains` method for the removed element.
    System.out.println("The bag contains the string one?\n" + bag.contains("one"));
//Test the `count` method for the removed element.
    System.out.println("The bag has this many one entries:\n" + bag.count("one"));

  }

}
