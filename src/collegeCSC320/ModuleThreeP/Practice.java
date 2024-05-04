package collegeCSC320.ModuleThreeP;

import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

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

    }

}
