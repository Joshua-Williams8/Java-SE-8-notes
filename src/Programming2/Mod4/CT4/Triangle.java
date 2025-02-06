package Programming2.Mod4.CT4;

class Triangle extends Shape {

  private double lengthSide1;

  public double getLengthSide1() {
    return lengthSide1;
  }

  public void setLengthSide1(double lengthSide1) {
    this.lengthSide1 = lengthSide1;
  }

  public double getLengthSide2() {
    return lengthSide2;
  }

  public void setLengthSide2(double lengthSide2) {
    this.lengthSide2 = lengthSide2;
  }

  public double getLengthSide3() {
    return lengthSide3;
  }

  public void setLengthSide3(double lengthSide3) {
    this.lengthSide3 = lengthSide3;
  }

  private double lengthSide2;
  private double lengthSide3;

  public double semiPerimeter() {
    return perimeter() / 2.0;
  }

  public double area() {
    return Math.sqrt(
      semiPerimeter()
        * (semiPerimeter() - lengthSide1)
        * (semiPerimeter() - lengthSide2)
        * (semiPerimeter() - lengthSide3)
    );
  }

  public double perimeter() {
    return lengthSide1 + lengthSide2 + lengthSide3;
  }

  Triangle(double lengthSide1, double lengthSide2, double lengthSide3){
    this.lengthSide1 = lengthSide1;
    this.lengthSide2 = lengthSide2;
    this.lengthSide3 = lengthSide3;
  }

  public String toString() {
    return "Area: " +  area() + "\nPerimeter: " + perimeter();
  }
}
