package programming;

//import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;
import static java.time.DayOfWeek.*;

//Time imports below

//import java.time.LocalTime;
//import static java.time.temporal.ChronoUnit.*;

//DateTime imports

import java.time.*;
import static java.time.Month.*;
import static java.time.temporal.ChronoUnit.*;

public class JavaDates {
  public static void main(String[] args) {
    //  NOTE Local Date Example
    LocalDate now, bDate, nowPlusMonth, nextTues;

    now = LocalDate.now();
//    System.out.println("Now: " + now);

    bDate = LocalDate.of(1995, 5, 23);
//    System.out.println("Bdate: " + bDate);
//    Checks if bdate is before the now date.
//    System.out.println(bDate.isBefore(now));
//    checks id bdate is in aleap year
//    System.out.println(bDate.isLeapYear());
//Bdate's day of the week
//    System.out.println(bDate.getDayOfWeek());
//    Plus 1 month
    nowPlusMonth = now.plusMonths(1);
//    System.out.println("plus 1 month "+nowPlusMonth);
// The very next tuesday(In this case it was tomorrow cause 18 to 19
    nextTues = now.with(next(TUESDAY));
//    System.out.println("Next tuesday date " + nextTues);


//    NOTE Time stuff below.
    LocalTime nowT, nowPlus, nowHrsMins, bedTime;

    nowT = LocalTime.now();
//    System.out.println(nowT);
//Plus an hour and 15 minutes
    nowPlus = nowT.plusHours(1).plusMinutes(15);
//    System.out.println(nowPlus);
// ONly up to the minute instead of miliseconds/seconds
    nowHrsMins = nowT.truncatedTo(MINUTES);
//    System.out.println(nowHrsMins);

    bedTime = LocalTime.of(23,30);
//    System.out.println(bedTime);

    long minsToLunch = nowT.until(bedTime, MINUTES);
//    System.out.println(minsToLunch);

//    NOTE DateTime stuff below

    LocalDateTime meeting,flight,courseStart,courseEnd;

    meeting = LocalDateTime.of(2014,MARCH,21,13,30);
//    System.out.println(meeting);

    LocalDate flightDate = LocalDate.of(2014,MARCH,31);
    LocalTime flightTime = LocalTime.of(21,45);
    flight = LocalDateTime.of(flightDate,flightTime);
//    System.out.println(flight);

    courseStart = LocalDateTime.of(2014,MARCH,24,9,00);
    courseEnd = courseStart.plusDays(4).plusHours(8);
//    System.out.println(courseStart);
//    System.out.println(courseEnd);

    long courseHrs = (courseEnd.getHour() - courseStart.getHour()) * (courseStart.until(courseEnd,DAYS)+1);
//    System.out.println(courseHrs);
//    System.out.println(courseStart.until(courseEnd,DAYS));

//    NOTE Timezone stuff.

    ZoneId LA = ZoneId.of("America/Los_Angeles");
    ZoneId NY = ZoneId.of("America/New_York");

//    Flight from LA to NY

    LocalDateTime dep = LocalDateTime.of(2014,JUNE,13,22,30);
    ZonedDateTime depLA = ZonedDateTime.of(dep,LA);
    System.out.println(depLA);

//    Depature in ny timezone

    ZonedDateTime depNY = depLA.toOffsetDateTime().atZoneSameInstant(NY);
    System.out.println(depNY);

    ZonedDateTime arrNY = depLA.plusHours(5).plusMinutes(30).toOffsetDateTime().atZoneSameInstant(NY);
    System.out.println(arrNY);



  }




}
