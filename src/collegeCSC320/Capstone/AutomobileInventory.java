package collegeCSC320.Capstone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomobileInventory {
  private List<Automobile> automobiles = new ArrayList<>();

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
      inventoryList.add("There was an issue with your list request, " +
        "here is the exception message: \n");
      inventoryList.add(ex.toString());
    }
      return inventoryList;
  }

  //Created just to display the listInventory output, since it needs to be repeated.
  public void displayInventory(){
    for (String listItem : this.listInventory()){
      System.out.println(listItem);
    }
  }

  public int findVin(String vin) {
    int carIndex = -1;
    boolean carFound = false;
    int count = 0;

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

  public String addAutomobile (String make, String model, String vin,
                               String color, int year, int mileage, double price) {
    String message = "";
    try {
      Automobile newCar = new Automobile(make, model, vin, color, year, mileage, price);
      automobiles.add(newCar);
      message = "Automobile successfully Added \n";
    } catch (Exception ex){
      message = "There was an issue adding your car. Error below: \n" + ex.toString();
    }
    return message;
  }

  public String deleteAutomobile(String vin) {
    int vinIndex = findVin(vin);
    String output = "";
    try {
      if (vinIndex == -1) {
        output = vin + " not found, please check the list to ensure " +
          "you entered the correct vin.\n";
      } else {
        this.getAutomobiles().remove(vinIndex);
        output =  vin + " was deleted.\n";
      }
    } catch (Exception ex ) {
      output = "Trying to delete: " + vin + ". ran into an issue exception " +
        "information below.\n" + ex.toString();
    }
    return output;
  }

  public String updateAutomobile (String make, String model, String vin, String color,
                                  int year, int mileage, double price) {
    int vinIndex = findVin(vin);
    String output = "";

    try {
      if (vinIndex == -1) {
        output = vin + " not found, please check the list to ensure you entered " +
          "the correct vin.\n";
      } else {
        Automobile update = new Automobile(make, model, vin, color, year, mileage, price);
        automobiles.set(vinIndex, update);
        output = vin + " successfully updated.\n";
      }
    } catch (Exception ex) {
      output = "There was an issue updating " + vin + ".\n Exception information below.\n"
        + ex.toString();
    }

    return output;
  }

  public void writeToFile () {

    StringBuilder inventoryList = new StringBuilder();
    for (String listItem : this.listInventory()){
      inventoryList.append(listItem);
    }

    try {
      //Note: the path is for my MAC, you will need to edit this depending on your own path.
      File newTextFile = new File(File.separator + "tmp" + File.separator + "Autos.txt");

      FileWriter fw = new FileWriter(newTextFile);
      fw.write(inventoryList.toString());
      fw.close();

    } catch (IOException ex) {
      System.out.println("There was an issue printing the file: \n" + ex.toString());
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
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
      System.out.println("findVin Test Successful\n");
    } else {
      System.out.println("Test findVin Failed");
    }
    //End Test findVin

    //Test addAutomobile
    String addAutoTest = testInventory.addAutomobile("Doge", "Dunder Bird", "DDDDD", "Dcolor", 4000, 444, 4600.40);
    if (testInventory.getAutomobiles().size() == 4) {
      System.out.println(addAutoTest);
      testInventory.displayInventory();
    } else {
      System.out.println("Test addAutomobile Failed");
    }
    //End Test addAutomobile

    //Test deleteAutomobile
    String deleteAutoTest = testInventory.deleteAutomobile( "CCCCC");
    if (testInventory.getAutomobiles().size() == 3) {
      System.out.println(deleteAutoTest);
      testInventory.displayInventory();
    } else {
      System.out.println("Test deleteAutomobile Failed");
    }
    //End Test deleteAutomobile

    //Test updateAutomobile
    String updateAutoTest = testInventory.updateAutomobile("Bodge", "Bunder Bird", "BBBBB", "Better Color", 2014, 500, 4999.40);
    if(testInventory.getAutomobiles().get(1).getYear() == 2014) {
      System.out.println(updateAutoTest);
      testInventory.displayInventory();
    } else {
      System.out.println("Test updateAutomobile Failed");
    }
    //End Test updateAutomobile

    //Write to file
    String response = "";
    while(!response.equalsIgnoreCase("y") || !response.equalsIgnoreCase("n") ) {
      System.out.println("Would you like to print this information to a file? (Y or N)");
      try {
        response = scanner.next();
      } catch (Exception ex) {
        System.out.println("There was an issue with your input. ");
      }
      if (response.equalsIgnoreCase("y")) {
        System.out.println("Saving to: C:\\tmp\\Autos.txt ");
        try {
          //Note: Change file path in writeToFile method, if an exception is thrown.
          testInventory.writeToFile();
        } catch (Exception ex ){
          System.out.println("Issue saving data.");
        }
        break;
      } else if (response.equalsIgnoreCase("n")) {
        System.out.println("Goodbye.");
        break;
      } else {
        System.out.println("Invalid response given");
      }
    }
    //End Write to file
  }

}
