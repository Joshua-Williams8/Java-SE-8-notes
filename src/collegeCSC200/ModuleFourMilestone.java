package collegeCSC200;

import java.util.ArrayList;

public class ModuleFourMilestone {
  public static void main(String[] args) {
    ArrayList<String> testList = new ArrayList<>();
    testList.add("One");
    testList.add("Two");
    testList.add("Three");
    testList.add("Four");
    System.out.println(testList.toString());
    ArrayList<String> copyList = testList;
    copyList.remove(0);
    System.out.println(testList.toString());

  }
}
