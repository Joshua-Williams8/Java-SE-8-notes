package programming;

public class Employee {
  private String empID;
  private String name;
  private String dept;
  private Integer age;

  public Employee(String empID, String name, String dept, Integer age) {
    this.empID = empID;
    this.name = name;
    this.dept = dept;
    this.age = age;
  }

  public String getEmpID() {
    return empID;
  }

  public void setEmpID(String empID) {
    this.empID = empID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
  @Override
  public String toString(){
    return this.name;
  }
}
