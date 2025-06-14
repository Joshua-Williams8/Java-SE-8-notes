package collegeCSC400.MOD2;

public class DicussionPost {
  public static void main(String[] args) {
//    Define array and give a simple code example demonstrating your understanding.
//    How can you determine if you would need to utilize a fixed-size array
//    or a dynamically-resizable array?
    int[] tirePressures = new int[4];
    tirePressures[0] = 33;
    tirePressures[1] = 31;
    tirePressures[2] = 32;
    tirePressures[3] = 33;
    //while car on
    for (int tireP : tirePressures) {
      if (tireP < 30) {
        // Display low tire pressure light
      }
    }
  }
}
