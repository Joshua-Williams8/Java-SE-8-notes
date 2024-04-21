package collegeCSC200;

public class Temperature {
  public static void main(String[] args) {
    double f = 212;

    double c = (5.0/9.0)*(f-32); //need the .0 on the numbers so java treats them as floats/doubles instead of ints

    System.out.println(c);
    System.out.println(17/9); //should get 1, because java always rounds DOWN unless told to round up.
  }
}

