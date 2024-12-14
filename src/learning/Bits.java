package learning;

public class Bits {
  static int solution(int n, int k) {
    StringBuilder strBuild = new StringBuilder(Long.toBinaryString(n));
      System.out.println(strBuild);
//    strBuild.setCharAt(k, '0');
      strBuild.replace(k, k + 1, "0");
      System.out.println(strBuild);
//    return Integer.valueOf( String.valueOf(strBuild), 2);
//    String test = new StringBuilder("test");

    return Integer.valueOf(String.valueOf(new StringBuilder(Integer.toBinaryString(n)).replace(k, k + 1, "0")), 2);
//    return Integer.valueOf(String.valueOf(new StringBuilder(Integer.toBinaryString(n)).setCharAt(k, '0')), 2);
  }

  public static void main(String[] args) {
    int solu = solution(2147483647 , 16);
    System.out.println(solu);
    System.out.println(2147450879 == solu);
  }
}
