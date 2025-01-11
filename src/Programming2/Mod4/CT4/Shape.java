package Programming2.Mod4.CT4;

 abstract class Shape {

  public abstract double area();

  public abstract double perimeter();

 }

 class Rectangle extends Shape {

   public double width;

   public double length;

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

class Circle extends Shape {

  public double radius;

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

class Triangle extends Shape {

  public double lengthSide1;
  public double lengthSide2;
  public double lengthSide3;

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


