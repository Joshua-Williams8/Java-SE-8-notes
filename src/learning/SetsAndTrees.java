package learning;

import java.util.*;

public class SetsAndTrees {
  public static void main(String[] args) {
//    Set is abstract and is the generic for sets
    HashSet<String> testHashSet = new HashSet<>();
    TreeSet<String> testTreeSet = new TreeSet<>();
    testHashSet.add("str2");
    testHashSet.add("str4");
    testHashSet.add("str5");
    testHashSet.add("str1");

    testTreeSet.add("str4");
    testTreeSet.add("str5");
    testTreeSet.add("str2");
    testTreeSet.add("str1");

    System.out.println("Hash below");

    for (String s : testHashSet) {
      System.out.println(s);
    }
    System.out.println("Tree below");

    for (String s : testTreeSet) {
      System.out.println(s);
    }

    TreeMap<String, Integer> testTreeMap = new TreeMap<>();
    testTreeMap.put("str4", 44);
    testTreeMap.put("str5", 33);
    testTreeMap.put("str2", 0);
    testTreeMap.put("str1", 10);

    for (String s : testTreeMap.keySet()) {
      System.out.println(s);
      System.out.println(testTreeMap.get(s));
    }



  }
}
