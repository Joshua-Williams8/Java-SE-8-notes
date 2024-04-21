package collegeCSC200.ModuleEight;

public class Package {

  private int trackingNumber;
  private int weight;
  private int height;
  private int length;
  private int width;
  private String currentActivity;
  private Person sender;
  private Person receiver;

  public Package(int trackingNumber, int weight, int height, int length, int width, String currentActivity, Person sender, Person receiver) {
    this.trackingNumber = trackingNumber;
    this.weight = weight;
    this.height = height;
    this.length = length;
    this.width = width;
    this.currentActivity = currentActivity;
    this.sender = sender;
    this.receiver = receiver;
  }

  public Package(){

  }

  public int getTrackingNumber() {
    return trackingNumber;
  }

  public void setTrackingNumber(int trackingNumber) {
    this.trackingNumber = trackingNumber;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public String getCurrentActivity() {
    return currentActivity;
  }

  public void setCurrentActivity(String currentActivity) {
    this.currentActivity = currentActivity;
  }

  public Person getSender() {
    return sender;
  }

  public void setSender(Person sender) {
    this.sender = sender;
  }

  public Person getReceiver() {
    return receiver;
  }

  public void setReceiver(Person receiver) {
    this.receiver = receiver;
  }

}
