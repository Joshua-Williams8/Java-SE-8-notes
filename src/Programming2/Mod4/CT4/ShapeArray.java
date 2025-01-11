package Programming2.Mod4.CT4;

public class ShapeArray {

  public static void main(String[] args) {

    Triangle tri = new Triangle(5,4,5);
    Circle cir = new Circle(5);
    Rectangle rec = new Rectangle(5,5);

    Shape[] shapeArray = {tri, cir, rec};

    for (Shape shape : shapeArray) {
      System.out.println(shape.toString());
    }

  }
}
