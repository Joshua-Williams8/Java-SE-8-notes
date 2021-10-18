package programming.shapes;

//public class Circle(double radius) { // ?? Use this?
public class Circle extends Shape{


  public double radius;

  public Circle(double radius){
    this.radius = radius;
  }

  @Override
  public double getPerimeter() {
    return getCircumference();
  }

  @Override
  public double getArea(){
    return Math.PI * (Math.pow(this.radius,2));
  }

  public double getCircumference(){
    return 2 * Math.PI * this.radius;
  }










}
