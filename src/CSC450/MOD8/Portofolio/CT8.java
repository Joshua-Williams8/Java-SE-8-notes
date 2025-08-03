package CSC450.MOD8.Portofolio;

public class CT8 {
  public static Integer count = 0;

  static class upThread extends Thread {
    @Override
    public void run() {
      System.out.println("Up Outside mutex");
      synchronized (count) {
        System.out.println("Up inside mutex");

        System.out.println("Up Start at: " + count);
        for (int i = 0; i < 20; i++) {
          count++;
          if (count%5 == 0) {
            System.out.println("Up Check: " + count);
          }
        }
      }
      System.out.println("Up End at: " + count);
    }
  }

  static class downThread extends Thread {
    @Override
    public void run() {
      System.out.println("Down Outside mutex");
      synchronized (count) {
        System.out.println("Down inside mutex");
        System.out.println("Down Start at: " + count);
        for (int i = 0; i < 20; i++) {
          count--;
          if (count % 5 == 0) {
            System.out.println("Down Check: " + count);
          }
        }
      }
      System.out.println("Down End at: " + count);
    }
  }

  public static void main(String[] args) {

    long startTime = System.currentTimeMillis(); // Or System.nanoTime() for higher precision
    // Your code to be tested

    System.out.println("Counter starting at: " + count);
    upThread threadOne = new upThread();
    downThread threadTwo = new downThread();
    threadOne.start();
    threadTwo.start();

    long endTime = System.currentTimeMillis();
    long elapsedTime = endTime - startTime; // In milliseconds or nanoseconds
    System.out.println("Execution time: " + elapsedTime + " ms");
  }
}
