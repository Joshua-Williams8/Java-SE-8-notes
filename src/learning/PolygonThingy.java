package learning;

import java.util.*;

public class PolygonThingy {

  static String solution(String[] logs) {
    // The first string is the key for, aka the switch statement
    // The hashset string is every log statement under the switch.
    // This way if we get a a duplicate log we don't accidentally count it
    //And we don't have to iterate through the list if we used an array list instead.

    HashMap<String, HashSet<String>> switchLogs = new HashMap<>();
    String currentSwitch = "";

    for (int i = 0; i < logs.length; i++) {
      if (logs[i].substring(0, 6).equals("switch")) {
//        System.out.println("Found a switch");
        // if the switch is called twice it fails because it doesn't add on to the current counter
        //We need to check if the key exist already before, we make a new one vs grabing the old.
        if (switchLogs.containsKey(logs[i])) {
          currentSwitch = logs[i];
        }
        else {
          switchLogs.put(logs[i], new HashSet<>());
//        System.out.println(switchLogs.get(logs[i]).size());
          currentSwitch = logs[i];
        }

      } else {
        switchLogs.get(currentSwitch).add(logs[i]);
      }
    }
    int currentMaxCount = switchLogs.get(currentSwitch).size();
    for (Map.Entry<String, HashSet<String>> switchLog : switchLogs.entrySet()) {
      String key = switchLog.getKey();
      Object value = switchLog.getValue();
      if (switchLogs.get(key).size() > currentMaxCount) {
        currentMaxCount = switchLogs.get(key).size();
        currentSwitch = key;
      }
    }



    return currentSwitch.substring(7);
  }


  public static void main (String[] args) {
    String[] test1 = new String[9];
    test1[0] = "switch branch1";
    test1[1] = "switch branch2";
    test1[2] = "push file2";
    test1[3] = "push file4";
    test1[4] = "switch branch3";
    test1[5] = "push file1";
    test1[6] = "push file1";
    test1[7] = "push file1";
    test1[8] = "switch branch2";

    System.out.println("We want it to retrurn just branch1");
    System.out.println(solution(test1));



  }

}
