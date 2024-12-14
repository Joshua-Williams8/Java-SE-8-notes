package Programming2.Mod1;

public class DicussionPost {
  public static void main(String[] args) {

    Bird blueJay = new BlueJay();
    Bird crow = new Crow();

    //prints tweet
    System.out.println(blueJay.birdCall());
    //prints caw
    System.out.println(crow.birdCall());
  }
}
