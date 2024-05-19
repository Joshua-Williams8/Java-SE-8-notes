package collegeCSC320.ModuleThreeP;

import java.util.Scanner;

public class Practice {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    /*
      int int1 = scanner.nextInt();
      int int2 = scanner.nextInt();
      int int3 = scanner.nextInt();
      int smallest = int1;

      if (int1 >= int2) {
        smallest = int2;
      }
      if (int2 >= int3) {
        smallest = int3;
      }
      System.out.println(smallest);

      switch (smallest){
        case 5:
          System.out.println("hello");
          break;
        case 10:
          System.out.println("goodbye");
          break;
        default:
          System.out.println("default");
          break;
      }

     */ //Commented out to test some other code
//      String num1 ;
//      int num2 = 5;
//      if (num1 != null && num1.length() > 0) {
//        System.out.println("inside the if");
//      }
    float[][] discounts = {
      {0, 10, 20, 50},
      {0, 0.05F, 0.10F, 0.20F}
    };

    float amountSpent = scanner.nextFloat(); //user input
    float discount = 0; //calculating for this
    System.out.println(amountSpent);
    for (int i = 0; i < 4; ++i) {
        if (amountSpent >= discounts[0][i]) {
          if (i != 0) {
          discount = discounts[1][i];
          } else {
            discount = discounts[0][0];
          }
          System.out.println(discount);
        }
    }
    System.out.println("Discount: " + discount);

  }
}
