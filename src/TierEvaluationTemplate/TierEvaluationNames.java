package TierEvaluationTemplate;

import java.sql.Date;
import java.util.*;

public class TierEvaluationNames {


  public static void main(String[] args) {
    TierEvaluationDTO ted1 = new TierEvaluationDTO();
    ted1.firstName = "Aaaaa";
    ted1.lastName = "Bbbbb";
    ted1.phoneNumber = 1111111111L;
    ted1.rsid = 100;
    ted1.expectedDate = Date.valueOf("2015-01-15");
    ted1.inputDate = Date.valueOf("2015-01-30");


    TierEvaluationDTO ted2 = new TierEvaluationDTO();
      ted2.firstName = "Mmmmm";
      ted2.lastName = "Ddddd";
      ted2.phoneNumber = 2222222222L;
      ted2.rsid = 700;
      ted2.expectedDate = Date.valueOf("2015-03-14");
      ted2.inputDate = Date.valueOf("2015-03-29");
    TierEvaluationDTO ted3 = new TierEvaluationDTO();
      ted3.firstName = "Eeeee";
      ted3.lastName = "Fffff";
      ted3.phoneNumber = 3333333333L;
      ted3.rsid = 300;
      ted3.expectedDate = Date.valueOf("2015-04-13");
      ted3.inputDate = Date.valueOf("2015-04-28");
    TierEvaluationDTO ted4 = new TierEvaluationDTO();
      ted4.firstName = "Ggggg";
      ted4.lastName = "Hhhhh";
      ted4.phoneNumber = 4444444444L;
      ted4.rsid = 400;
      ted4.expectedDate = Date.valueOf("2015-05-12");
      ted4.inputDate = Date.valueOf("2015-05-27");
    TierEvaluationDTO ted5 = new TierEvaluationDTO();
      ted5.firstName = "Iiiii";
      ted5.lastName = "Jjjjj";
      ted5.phoneNumber = 5555555555L;
      ted5.rsid = 500;
      ted5.expectedDate = Date.valueOf("2015-06-11");
      ted5.inputDate = Date.valueOf("2015-06-26");
    TierEvaluationDTO ted6 = new TierEvaluationDTO();
      ted6.firstName = "Ccccc";
      ted6.lastName = "Ooooo";
      ted6.phoneNumber = 7777777777L;
      ted6.rsid = 200;
      ted6.expectedDate = Date.valueOf("2015-07-10");
      ted6.inputDate = Date.valueOf("2015-07-25");

    List<TierEvaluationDTO> tedList = new ArrayList<>();

    tedList.add(ted1);
    tedList.add(ted2);
    tedList.add(ted3);
    tedList.add(ted4);
    tedList.add(ted5);
    tedList.add(ted6);

    //Now we want to reorganize the data we've set up for our list.
    //We want to beable to sort it by all the data, top to bottom or bottom to top.

    for (TierEvaluationDTO tedTest : tedList) {
      System.out.println(tedTest.firstName);

    }

    System.out.println("_______________" );

//    Collections.sort(tedList,((o1, o2) -> o1.rsid - o2.rsid));

//    tedList.sort((Comparator.comparingInt(o -> o.rsid)));
    tedList.sort((Comparator.comparing(o -> o.firstName)));


    //We want to be able to check our data so we need to print the list in order after the order is changed, vs the default.
    for (TierEvaluationDTO tedTest : tedList) {
      System.out.println(tedTest.firstName);

    }

    System.out.println("_______________ Reversed Int list" );

    Collections.reverse(tedList);

    for (TierEvaluationDTO tedTest : tedList) {
      System.out.println(tedTest.firstName);

    }
  }
}
