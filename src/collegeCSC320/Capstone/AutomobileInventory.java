package collegeCSC320.Capstone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomobileInventory {
  private List<Automobile> automobiles = new ArrayList<>();
  private Scanner scanner = new Scanner(System.in);

  public AutomobileInventory(){

  }
  public AutomobileInventory(List<Automobile> automobiles){
    this.automobiles = automobiles;
  }

  public void setAutomobiles(List<Automobile> automobiles) {
    this.automobiles = automobiles;
  }
  public List<Automobile> getAutomobiles() {
    return automobiles;
  }

  public List<String> listInventory () {
    List<String> inventoryList = new ArrayList<>();
    try {
      for (int i = 0; i < getAutomobiles().size(); ++i) {
        inventoryList.add(getAutomobiles().get(i).getAutomobileInfo());
      }
    } catch (Exception ex) {
      inventoryList.add("There was an issue with your list request, here is the exception message: \n");
      inventoryList.add(ex.toString());
    }
      return inventoryList;
  }
//  public int findVin (string vin) {
//Int carIndex = -1; //We want an invalid number here just incase
//bool carFound = false;
//for (int i = 0; i < getAutomobiles.size(); ++i) {
//if ( getAutomobiles.get(i).getVin == vin) {
//carIndex = i;
//carFound = true;
//i = getAutomobiles.size() // should end for loop? } end if
//} end for loop
//return carIndex
//} end of findVin

  public int findVin(String vin) {
    int carIndex = -1;
    boolean carFound = false;
    int count = 0;

    System.out.println(getAutomobiles().size());
    try {
      while (!carFound || count < getAutomobiles().size()) {

        if (getAutomobiles().get(count).getVin().equalsIgnoreCase(vin)) {
          carIndex = count;
          carFound = true;
        }
        ++count;
      }
    } catch (Exception ex) {
      System.out.println("There was an issue finding the VIN for " + vin);
      System.out.println(ex.toString());
    }
    return carIndex;
  }

  public static void main(String[] args) {
    //Setting up test data
    Automobile testA = new Automobile("AIK", "Amod", "AAAAA", "Acolor", 1000, 111, 1900.10 );
    Automobile testB = new Automobile("Bord", "Bodel", "BBBBB", "Bcolor", 2000, 222, 2800.20 );
    Automobile testC = new Automobile("Conda", "Charger", "CCCCC", "Ccolor", 3000, 333, 3700.30 );

    List<Automobile> testAutos = new ArrayList<>();
    testAutos.add(testA);
    testAutos.add(testB);
    testAutos.add(testC);

    AutomobileInventory testInventory = new AutomobileInventory(testAutos);
    //End of test data setup

    //Test listInventory
    for (String listItem : testInventory.listInventory()){
      System.out.println(listItem);
    }
    //End Test listInventory

    //Test findVin
    int expectedInt = 2;
    if (testInventory.findVin("ccccc") == expectedInt) {
      System.out.println("Test Successful");
    }
    //End Test findVin

  }

}
