package Programming2.Mod4.CT4;

class Rectangle extends Shape {

  private double width;
  private double length;

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double area() {
    return width * length;
  }
  public double perimeter() {
    return (width * 2) + (length * 2);
  }

  Rectangle(double width, double length){
    this.width = width;
    this.length = length;
  }

  public String toString() {
    return "Area: " +  area() + "\nPerimeter: " + perimeter();
  }
}
