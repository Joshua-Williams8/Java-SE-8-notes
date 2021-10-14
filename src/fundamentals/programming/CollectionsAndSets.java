package fundamentals.programming;

import fundamentals.programming.shapes.Measurable;
import fundamentals.programming.shapes.Rectangle;
import fundamentals.programming.shapes.Square;

import java.util.ArrayList;
import java.util.List;

public class CollectionsAndSets {
  List<String> testList = new ArrayList<>();
//  You can instantiant or store an objects in a list using the most generic version, so you don't have to have different list.
//Like how in our Shapes Test we can call Measurable to make a rectangle object, even though it extends off of quadrilateral

  public static void main(String[] args) {
    List<Measurable> shapesTest = new ArrayList<>();

    shapesTest.add(new Rectangle(2,4));
    shapesTest.add(new Square(3));

    for(Measurable shape: shapesTest){
      System.out.println(shape.getClass());
      System.out.println(shape.getArea());
      System.out.println(shape.getPerimeter());
    }

  }

}
