package collegeCSC200.ModuleSix;

import java.util.PriorityQueue;

public class CriticalThinkingSix {
  public static void main(String[] args) {
    PriorityQueue<String> strings = new PriorityQueue<>();

    strings.add("AOne");

    strings.add("BTwo");

    strings.add("CThree");
    strings.add("DFour");
//    strings.remove("Three");

//    System.out.println(strings.peek());
//    String firstString = strings.peek();
//    System.out.println(firstString);

//    System.out.println(strings.toString());
//    System.out.println( strings.element());



//    poll removes head or first element
//    strings.poll();
//    strings.poll();
    //remove will throw an exception if the queue is empty but poll will NOT
//    strings.remove();


    System.out.println(strings.toString());


    //Removes all elements
    //strings.clear();
    for(int i = 0; i != 5; i++)  {

    }


  }
}
