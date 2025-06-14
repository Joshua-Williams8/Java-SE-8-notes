package collegeCSC400.MOD8.Project;

public class Person {
  private String firstName;
  private String lastName;
  //Chose to use a short since we are not going to be needing extremely high numbers
  private Short age;

  public Person(String firstName, String lastName, Short age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Short getAge() {
    return age;
  }

  public void setAge(Short age) {
    this.age = age;
  }
}
