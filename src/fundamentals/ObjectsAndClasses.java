package fundamentals;

public class ObjectsAndClasses {
  int[] testArray = new int[3];
//  You have to put the new to make the array properly dude.

  public static void main(String[] args) {
    Item item1, item2;

    item1 = new Item();
    item2 = new Item();

    item1.desc = "Shirt";
    item1.itemID = 654321;
    item2.desc = "Pants";
    item2.itemID = 135246;
    System.out.println(item1.desc + " is item1 description.");
    System.out.println(item2.desc + " is item2 description.");
    System.out.println(item1);
    System.out.println(item2);


    item1 = item2;
//Now both reference the same data, item1 is NOT a copy of item2, they are not looking at the same data.
    System.out.println(item1.desc + " is item1 description.");
    System.out.println(item2.desc + " is item2 description.");
    System.out.println(item1);
    System.out.println(item2);

//NOTE regular expression basics

    item1.desc.matches(".*sab.*"); // This checks to see if the string has "sab" in the string
    System.out.println(item1.desc.matches(".*sab.*"));
    item1.desc = "sabrina";
    System.out.println(item1.desc.matches(".*sab.*"));
    item1.desc = "it's not sab bro";
    System.out.println(item1.desc.matches(".*sab.*"));

//    Math.random()


  }
}
