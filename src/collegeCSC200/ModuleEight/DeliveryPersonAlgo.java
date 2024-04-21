package collegeCSC200.ModuleEight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryPersonAlgo {
  //Setting up a test situation for a Delivery Driver to input packages into their truck
  public static Person sender1 = new Person("Andrew","Andrew's Address");
  public static Person sender2 = new Person("Bryce","Bryce's Address");
  public static Person sender3 = new Person("Cameron","Cameron's Address");
  public static Person sender4 = new Person("Duke","Duke's Address");

  public static Person receiver1 = new Person("Lois","Lois's Address");
  public static Person receiver2 = new Person("Nikki","Nikki's Address");
  public static Person receiver3 = new Person("Kayla","Kayla's Address");
  public static Person receiver4 = new Person("Maria","Maria's Address");

  public static boolean packageFound(List<Package> packageList, int trackingNumber){
    for(Package item: packageList){
      if(item.getTrackingNumber() == trackingNumber){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    //More testing Setup
   Package package1 = new Package(1,1,1,1,1,"At Storage",sender1,receiver1);
   Package package2 = new Package(2,2,2,2,2,"At Storage",sender2,receiver2);
   Package package3 = new Package(3,3,3,3,3,"At Storage",sender3,receiver3);
   Package package4 = new Package(4,4,4,4,4,"At Storage",sender4,receiver4);
    //Setting up packages in storage
    List<Package> packagesInStorage = new ArrayList<>();
    packagesInStorage.add(package1);
    packagesInStorage.add(package2);
    packagesInStorage.add(package3);
    packagesInStorage.add(package4);
    Scanner input = new Scanner(System.in);

    //Start
    System.out.println("Hello Delivery Person there are currently " + packagesInStorage.size() + " packages available.");

    //Enter which package's tracking number you are taking
    //While loop incase you ask for an incorrect number?

    System.out.println("Please enter the tracking number of the package you are taking out for delivery: ");
    int packageTrackingNumber;
    packageTrackingNumber = Integer.parseInt(input.next());

    while(!packageFound(packagesInStorage,packageTrackingNumber)){
      System.out.println("Sorry we could not find that package.");
      System.out.println("Please enter the tracking number of the package you are taking out for delivery: ");
      packageTrackingNumber = Integer.parseInt(input.next());
    }

    Package packageToDeliver = new Package();

    //Set the package being delivered
    for(Package item: packagesInStorage){
      if(item.getTrackingNumber() == packageTrackingNumber){
        packageToDeliver = item;
        //Remove it from the storage list
        packagesInStorage.remove(item);
      }
    }
    //Change the status so we know it's out for delivery
    packageToDeliver.setCurrentActivity("Out for Delivery");

    //Checking package details, and list size to make sure we removed one.
    System.out.println("This package is from " + packageToDeliver.getSender().getName());
    System.out.println("It's going to " + packageToDeliver.getReceiver().getName() + " at their address: " + packageToDeliver.getReceiver().getAddress());
    System.out.println("There are " + packagesInStorage.size() + " left in storage.");

  }
}
