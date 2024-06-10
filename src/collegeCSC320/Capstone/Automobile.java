package collegeCSC320.Capstone;

public class Automobile {
  private String make;
  private String model;
  private String vin;
  private String color;
  private int year;
  private int mileage;
  private double price;
  
  public Automobile(){

  }
  public Automobile(   String make, String model, String vin,
                       String color, int year, int mileage, double price){
    this.make = make;
    this.model = model;
    this.vin = vin;
    this.color = color;
    this.year = year;
    this.mileage = mileage;
    this.price = price;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMileage() {
    return mileage;
  }

  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
  public String getAutomobileInfo(){
    StringBuilder info = new StringBuilder();
    info.append("Make: " + this.make + ", ");
    info.append("Model: " + this.model + ", ");
    info.append("Year: " + this.year + ", ");
    info.append("VIN: " + this.vin + "\n");
    info.append("Color: " + this.color + ", ");
    info.append("Mileage: " + this.mileage + ", ");
    info.append("Price: " + this.price + "\n");

    return info.toString();
  }
}
