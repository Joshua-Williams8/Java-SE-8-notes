package collegeCSC400.MOD1;

import java.util.Collection;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

public class DicussionPost {
  public static void main(String[] args) {
    Bag<String> bag = new HashBag<>();

    bag.add("apple");
    bag.add("banana");
    bag.add("apple");

    System.out.println("Count of apples: " + bag.getCount("apple")); // Output: 2
    System.out.println("Size of bag: " + bag.size()); // Output: 3

  }
}
