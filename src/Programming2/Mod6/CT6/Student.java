package Programming2.Mod6.CT6;

public class Student {
  public Integer rollno;
  public String name;
  public String address;

  public Student(Integer rollno, String name, String address) {
    this.rollno = rollno;
    this.name = name;
    this.address = address;
  }

  @Override
  public String toString(){
    return "Rollno: " + rollno+ " Name: " + name;
  }
}


