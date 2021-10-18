package programming.shapes.functionsInterfaces;

import java.util.ArrayList;
import java.util.List;

public class TestInterface {
  public static void main(String[] args) {

    List<String> testStrings = new ArrayList<>();

    testStrings.add("One");
    testStrings.add("Two");
    testStrings.add("Twenty One");
    testStrings.add("Thirty One");
    testStrings.add("Forty Two");

    testStrings.stream()
      .filter(s -> s.contains("One"))
//      Below is using a consumer interface(The one that returns void) to print out the strings that contain One.
      .forEach(System.out::println);

  }





}
