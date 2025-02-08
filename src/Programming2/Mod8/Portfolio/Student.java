package Programming2.Mod8.Portfolio;

public class Student {

  private String name;
  private String address;
  private Double gpa;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public double getGpa() {
    return gpa;
  }

  public void setGpa(double gpa) {
    this.gpa = gpa;
  }

  public Student(String name, String address, Double gpa) {
    this.name = name;
    this.address = address;
    this.gpa = gpa;
  }

  public String toString() {
    return "Name: " + name + "\nGPA: " + gpa + "\nAddress: " + address + "\n";
  }
}
