package collegeCSC400.MOD2.CT2;

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
    if (contains(item)) {
      items.put(item, items.get(item) + 1 );
    } else {
      items.put(item, 1);
    }
  }

  public void add(T item, int amount) {
    if (contains(item)) {
      items.put(item, items.get(item) + amount );
    } else {
      items.put(item, amount);
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
  distinct returns a Set<T> of keys or items currently in our bag.
  */
  public Set<T> getBagItems() {
    return items.keySet();
  }
  // NOTE: CT2 below (We changed getBagKeys to distinct)

//`int size()`: This method should return the total number of elements
// in the bag, including duplicates.
  public int size() {
    int sum = 0;
    for (T item : getBagItems() ) {
      sum = sum + count(item);
    }
    return sum;
  }
// `void merge(Bag<T> otherBag)`: This method should merge the elements of `otherBag`
// into the current bag.
  public void merge(Bag<T> otherBag) {
    for (T item : otherBag.getBagItems() ) {
      add(item, otherBag.count(item));
    }
  }
  // `Bag<T> distinct()`: This method should return a new bag that contains
// only the distinct elements from the current bag.
  public Bag<T> distinct() {
    Bag<T> outputBag = new Bag<>();
    for (T item : this.getBagItems() ) {
      outputBag.add(item);
    }
    items.keySet();
    return outputBag;
  }

  public static void CT1(String[] args) {

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

//  CT2 runner
  public static void CT2(String[] args) {
    //Add elements to each bag, including duplicates.

//Bag 1
    Bag bag1 = new Bag();
    bag1.add("two");
    bag1.add("two");
    bag1.add(3);
    bag1.add("one");
    bag1.add(3);
    bag1.add(3);
    bag1.add(4.2);
    bag1.add(4.2);
    bag1.add(4.2);
    bag1.add(4.2);

    //Bag 2 Duped two and 3
    Bag bag2 = new Bag();

    bag2.add("two");
    bag2.add("two");
    bag2.add(3);
    bag2.add(3);
    bag2.add(3.3);
    bag2.add(3.3);
    bag2.add(3.3);
    bag2.add("howdy");
    bag2.add("hello");
    bag2.add("matcha");
    bag2.add("matcha");
//Print the size of each bag using the `size` method.
    System.out.println("Bag 1 size: " + bag1.size());
    System.out.println("Bag 2 size: " + bag2.size());
    System.out.println("______________");
//Merge the two bags together using the `merge` method.
    bag1.merge(bag2);
//Print the merged bag contents.
    System.out.println("Bag 1 contents:");
    System.out.println("Bag 1 new size after merge: " + bag1.size());

    for (Object item : bag1.getBagItems()) {
      System.out.println(item + "\ncount: " + bag1.count(item));
    }
    System.out.println("______________");
//Create a new bag containing only the distinct elements using the `distinct` method.
//Print the distinct bag contents.
    Bag distinctBag = bag1.distinct();
    System.out.println("Distinct Bag contents:");

    for (Object item : distinctBag.getBagItems()) {
      System.out.println(item + "\ncount: " + distinctBag.count(item));
    }
  }

  public static void main(String[] args) {
//    CT1(new String[0]);
    CT2(new String[0]);

  }

}
