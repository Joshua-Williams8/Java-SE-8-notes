package Programming2.Mod5;

public class dicuss {

  public static void countUpTo(int start, int stop) {
    System.out.println(start);
    start++;
    if (start > stop) {
      System.out.println("Counting complete");
    } else {
      countUpTo(start, stop);
    }
  }

  public static void main(String[] args) {
    countUpTo(0,3);
  }
}
