package fundamentals.programming.shapes;


public class ShapesTest {
  public static void main(String[] args) {
    //Old stuff below
//    Rectangle box1 = new Rectangle(5,4);
//    System.out.println(box1.getPerimeter());
//    System.out.println(box1.getArea());
//    Rectangle box2 = new Square(5);
//    System.out.println(box2.getPerimeter());
//    System.out.println(box2.getArea());

    Measurable myShape = new Rectangle(4,5);
    System.out.println(myShape.getPerimeter());
    System.out.println(myShape.getArea());

    myShape = new Square(5);
    System.out.println(myShape.getPerimeter());
    System.out.println(myShape.getArea());
    //Below doesn't work because we can't access the abstract class directly.
    //If we want to use getLength we have to add it to our interface,
    //Our interface is limiting what we have access to.
//    System.out.println(myShape.getLength());

    //We need the getPerimeter method in rectangle because it's part of the abstract class blue print.
    //The getters were defined inside of Quadrilateral, so they're only accessible in there, but if we wanted to use methods we would need to reference the quadrilateral type.

  }
}
