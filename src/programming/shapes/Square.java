package programming.shapes;


public class Square extends Quadrilateral {

  public Square(double sides) {
    super(sides,sides);
  }

  @Override
  public double getPerimeter() {
    return (2 * this.length) + (2 * this.width);
  }

  @Override
  public double getArea() {
    return this.width * this.length;

  }

  @Override
  void setLength(double length) {
    this.length = length;

  }

  @Override
  void setWidth(double width) {
    this.width = width;
  }
//public class Square extends Rectangle { // From original.

//  private double side;
//
//
//
//  public Square(double side) {
//      super(side,side);
//      //Below is old solution with out superclass,
////      this.width = side;
////      this.length = side;
//      this.side = side;
//  }
//
//
//  public double getSide() {
//    return this.side;
//  }
//
//  public void setSide(double side) {
//    this.side = side;
//  }
//
//  @Override
//  public double getPerimeter() {
//    return 4 * this.side;
//  }
//
//  @Override
//  public double getArea() {
//    return Math.pow(this.side, 2 );
//  }
}
