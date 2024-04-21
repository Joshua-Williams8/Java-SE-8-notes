package collegeCSC320.moduleOneCT;

public class Person {
  private String firstName;
  private String lastName;
  private String streetAddress;
  private String city;
  private int zipCode;

  public Person(String firstName, String lastName, String streetAddress, String city, int zipCode) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.streetAddress = streetAddress;
    this.city = city;
    this.zipCode = zipCode;
  }

  public Person(){
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

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getZipCode() {
    return zipCode;
  }

  public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
  }

  public String getAddressInfo (){
    return this.getStreetAddress() + ", " + this.getCity() + ", " + this.getZipCode();
  }

  public static void main(String[] args) {
    Person person1 = new Person();
    person1.setFirstName("Brandon");
    person1.setLastName("Wilson");
    person1.setStreetAddress("555 Rainbow Rd.");
    person1.setCity("Charles Town");
    person1.setZipCode(12345);
    System.out.println(person1.getAddressInfo());
  }
}
