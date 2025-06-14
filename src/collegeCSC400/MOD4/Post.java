package collegeCSC400.MOD4;

import java.util.Stack;

public class Post {

  public static void main(String[] args) {
    Stack stk = new Stack();
    stk.add("first");
    stk.add("second");
    stk.add("third");
    System.out.println(stk.peek());
    stk.pop();
    System.out.println(stk.peek());

  }
}
