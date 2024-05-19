package collegeCSC320.ModuleFive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OptionOneCTList {
  static List<String> weekDays = new ArrayList<>() {
    {
      add("Monday");
      add("Tuesday");
      add("Wednesday");
      add("Thursday");
      add("Friday");
      add("Saturday");
      add("Sunday");
    }
  };
  static List<Integer> weekTemps = new ArrayList<>() {
    {
      add(91);
      add(84);
      add(79);
      add(76);
      add(80);
      add(87);
      add(83);
    }
  };

  private static Scanner scanner = new Scanner(System.in);


  private static void getDayTemp(int index) {
    System.out.println("The temperature for " + weekDays.get(index) + " is: "
      + weekTemps.get(index) + "\n" + "Enter any value to continue.\n");
      // Below is so user can read the line before continuing
    scanner.next();
  }

  public static void main(String[] args) {

    String userInput = " ";
    //Incase there are any special issues.
    int loopCount = 0;

    while(!userInput.equals("end") && loopCount < 20){
      ++loopCount;
      System.out.println("Please select from the options below. (enter 1 through 7, week or end.)");
      StringBuilder message = new StringBuilder();
      //Sets up message to display the day options.
      for (int i = 0; i < weekDays.size(); ++i){
        message.append(i + 1);
        message.append(" - ");
        message.append(weekDays.get(i));
        message.append("\n");
      }
      System.out.print(message);
      System.out.println("week - Summary of this week");
      System.out.println("end - Exit the program");
      System.out.println("Enter your response below.");
      userInput = scanner.next();
      userInput = userInput.toLowerCase();

      // Our options from the userInput.
      switch (userInput) {
        case "1":
          getDayTemp(0);
          break;
        case "2":
          getDayTemp(1);
          break;
        case "3":
          getDayTemp(2);
          break;
        case "4":
          getDayTemp(3);
          break;
        case "5":
          getDayTemp(4);
          break;
        case "6":
          getDayTemp(5);
          break;
        case "7":
          getDayTemp(6);
          break;
        case "week":
          int sum = 0;
          int average = 0;
          StringBuilder weekMessage = new StringBuilder();
          for (int i = 0; i < weekDays.size(); ++i){
            sum = sum + weekTemps.get(i);
            //Setting up the week message using StringBuilder.
            weekMessage.append(weekDays.get(i));
            weekMessage.append(": ");
            weekMessage.append(weekTemps.get(i));
            weekMessage.append(" degrees. \n");
          }

          average = sum/weekTemps.size();

          System.out.print(weekMessage);
          System.out.println("Average for the week: " + average + "\n");
          System.out.println("Enter any value to continue.");
          // Below is so user can read the line before continuing
          scanner.next();
          break;
        case "end":
          System.out.println("Have a good day, goodbye.");
          break;
          //If anything other than a valid input is given restart the loop.
        default:
          System.out.println("Invalid input please try again." + "\n");
          System.out.println("Enter any value to continue.");
          // Below is so user can read the line before continuing
          scanner.next();
          break;
      }
    }
  }
}
