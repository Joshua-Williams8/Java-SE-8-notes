package collegeCSC200.ModuleEight;

public class DeliveryDriver {

  private int driverId;
  private String name;
  private String currentActivity;



  public DeliveryDriver(int driverId, String name, String currentActivity) {
    this.driverId = driverId;
    this.name = name;
    this.currentActivity = currentActivity;
  }
  public DeliveryDriver(){
  }


  public int getDriverId() {
    return driverId;
  }

  public void setDriverId(int driverId) {
    this.driverId = driverId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCurrentActivity() {
    return currentActivity;
  }

  public void setCurrentActivity(String currentActivity) {
    this.currentActivity = currentActivity;
  }


}
