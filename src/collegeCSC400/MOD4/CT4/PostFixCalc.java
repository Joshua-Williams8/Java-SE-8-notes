package collegeCSC400.MOD4.CT4;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class PostFixCalc {
  public Stack<String> stack = new Stack<>();

  public String calulateString(String pfExpression) {
    //We want to substring through letter or
    // create a char array and turn them into strings again, then parse back into numbers as needed.
    //We'll do char array since it'll be faster to code up'

    String[] pfSeperated = new String[pfExpression.length()];
    stack.clear();

    for (int i = 0; i < pfSeperated.length; i++) {
      if (i == pfSeperated.length - 1) {
        pfSeperated[i] = pfExpression.substring(i);
        break;
      }
      pfSeperated[i] = pfExpression.substring(i, i + 1);
    }
    //Test the array length
//    System.out.println(pfExpression.length());
//    System.out.println(pfSeperated.length);

    for(String str: pfSeperated) {
      //Checking each operator breaking it up for read-ability
      boolean isPlus = str.equals("+");
      boolean isMinus = str.equals("-");
      boolean isMult = str.equals("*");
      boolean isDivide = str.equals("/");
      boolean isMod = str.equals("%");
      boolean isOperator = isPlus || isMinus || isMult || isDivide || isMod;
      //Test what my results are
//      System.out.println(str + " " + isOperator);
      //if the input is not an operator add to stack.
      if (!isOperator) {
        //Test input is a number.
        try {
          Long testValue = Long.parseLong(str);
        } catch (Exception e) {
//          System.out.println("Invalid Input given at: " + str);
          return "Invalid Input given at: " + str;
        }
        stack.add(str);
      } else {
        //Perform the operation here
        //Number two comes before one, because we grab from the top
        long numTwo;
        long numOne;

        try{
          numTwo = Long.parseLong(stack.pop());
          numOne = Long.parseLong(stack.pop());
        } catch (Exception e) {
          //Added this error message incase we get here without enough numbers in the stack.
          return "The expression was not sent correctly, and ran into an issue calculating at operator: " + str;
        }


        if (isPlus) {
          stack.add(String.valueOf(numOne + numTwo));
        }
        if (isMinus) {
          stack.add(String.valueOf(numOne - numTwo));
        }
        if (isMult) {
          stack.add(String.valueOf(numOne * numTwo));
        }
        if (isDivide) {
          stack.add(String.valueOf(numOne / numTwo));
        }
        if (isMod) {
          stack.add(String.valueOf(numOne % numTwo));
        }
      }
    }

    if (stack.size() != 1) {
      stack.clear();
      return "Invalid amount of inputs for calculation";
    }

    return stack.peek();
  }
  public void calculateFileLines(String filePath) {
    try {
      File expressions = new File(filePath);
      Scanner scanner = new Scanner(expressions);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println(line);
        System.out.println(calulateString(line));
      }
      scanner.close();
    } catch (Exception e) {
      System.out.println("There was an issue finding your file.");
//      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    PostFixCalc postFixCalc = new PostFixCalc();

    postFixCalc.calculateFileLines( File.separator + "tmp" + File.separator + "expressions.txt");

    //Example 1
//    System.out.println(postFixCalc.calulateString("19+"));
//    Should return 10, 19+ 1 + 9

    //Example 2
//    System.out.println(postFixCalc.calulateString("34+51+*"));
//    Should return 42, 34+51+* or (3 + 4) * (5 + 1)

    //Example 3
//    System.out.println(postFixCalc.calulateString("263*+5/"));
//    Should return 4, 263*+5/" or ((6 * 3) + 2) / 5

    //Example 4
//    System.out.println(postFixCalc.calulateString("34+53td"));
    // Should return an error message

    //Example 5
//    System.out.println(postFixCalc.calulateString("263*+3%"));
//    Should return 2, 263*+3%" or ((6 * 3) + 2) % 5

    //Example 6
//        System.out.println(postFixCalc.calulateString("3+"));
    // Should return an error message

  }
}
