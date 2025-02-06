package Programming2.Mod4.CT4;

class Circle extends Shape {

  private double radius;

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public double area() {
    return Math.PI * (Math.pow(radius, 2));
  }
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  Circle(double radius){
    this.radius = radius;
  }

  public String toString() {
    return "Area: " +  area() + "\nPerimeter: " + perimeter();
  }
}
