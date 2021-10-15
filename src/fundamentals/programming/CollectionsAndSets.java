package fundamentals.programming;

import fundamentals.programming.shapes.Circle;
import fundamentals.programming.shapes.Measurable;
import fundamentals.programming.shapes.Rectangle;
import fundamentals.programming.shapes.Square;

import java.util.*;

public class CollectionsAndSets {
  List<String> testList = new ArrayList<>();
//  You can instantiant or store an objects in a list using the most generic version, so you don't have to have different list.
//Like how in our Shapes Test we can call Measurable to make a rectangle object, even though it extends off of quadrilateral

  public static void main(String[] args) {
    List<Measurable> shapesTest = new ArrayList<>();

    shapesTest.add(new Rectangle(2,4));
    shapesTest.add(new Square(3));
//    NOTE Now with a circle which is not a quad...
    shapesTest.add(new Circle(4));

//    for(Measurable shape: shapesTest){
//      System.out.println(shape.getClass());
//      System.out.println(shape.getArea());
//      System.out.println(shape.getPerimeter());
//    }


//    NOTE Set INterface

//    A Set cannot have DUPLICATES!
//    A Set is UN ORDERED!
//    Since it's unordered they don't have/use indexes

    Set<String> set = new TreeSet<>();

    set.add("One");
    set.add("Two");
    set.add("Three");
//    set.add("Three");

//    for(String item:set){
//      System.out.println(item);
//    }
//    It printed out in alphabetical order instead of the order we made them, One Three, Two.

    Map<String, Integer> map = new TreeMap<>();
    map.put("Uno",1);
    map.put("Dos",2);
    map.put("Tres",3);

    for (Integer thing:map.values()){
      System.out.println(thing);
    }
//    It put each thing in order by key, and not the value?


//    Maps use KEy value pairs, aka associative arrays, good for tracking a purchase list, and descriptions?



//    NOTE DEQUE

    Deque<String> stack = new ArrayDeque<>();

    stack.push("Uno");
    stack.push("Dos");
    stack.push("Tres");

    int size = stack.size() - 1;

    while(size >= 0){
      System.out.println(stack.pop());
//      It poped from back to front,

//      System.out.println(stack.remove());
      size--;
    }
  }
}
