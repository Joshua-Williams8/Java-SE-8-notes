package Programming2.Mod7;

import java.util.HashSet;
import java.util.Set;

public class Dicuss7 {


  public static void main(String[] args) {
    Set testSet = new HashSet();
    testSet.add(111);
    testSet.add(222);
    testSet.add(333);
    testSet.add(111);
    //Prints 3
    System.out.println(testSet.size());
  }
}
