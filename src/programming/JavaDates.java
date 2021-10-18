package programming;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;
import static java.time.DayOfWeek.*;

//Time imports below

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.*;

public class JavaDates {
  public static void main(String[] args) {
    //  NOTE Local Date Example
    LocalDate now, bDate, nowPlusMonth, nextTues;

    now = LocalDate.now();
    System.out.println("Now: " + now);

    bDate = LocalDate.of(1995, 5, 23);
    System.out.println("Bdate: " + bDate);
//    Checks if bdate is before the now date.
    System.out.println(bDate.isBefore(now));
//    checks id bdate is in aleap year
    System.out.println(bDate.isLeapYear());
//Bdate's day of the week
    System.out.println(bDate.getDayOfWeek());
//    Plus 1 month
    nowPlusMonth = now.plusMonths(1);
    System.out.println("plus 1 month "+nowPlusMonth);
// The very next tuesday(In this case it was tomorrow cause 18 to 19
    nextTues = now.with(next(TUESDAY));
    System.out.println("Next tuesday date " + nextTues);





  }




}
