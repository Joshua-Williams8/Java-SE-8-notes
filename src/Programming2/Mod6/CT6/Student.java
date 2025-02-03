package Programming2.Mod6.CT6;

public class Student {

  private Integer rollno;
  private String name;
  private String address;

  public Integer getRollno() {
    return rollno;
  }

  public void setRollno(Integer rollno) {
    this.rollno = rollno;
  }

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

  public Student(Integer rollno, String name, String address) {
    this.rollno = rollno;
    this.name = name;
    this.address = address;
  }

  //Returns the student's Roll Number then Name behind
  @Override
  public String toString(){
    return "Rollno: " + rollno+ " Name: " + name;
  }
}


