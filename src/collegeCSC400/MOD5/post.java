package collegeCSC400.MOD5;

import java.util.ArrayList;
import java.util.List;

public class post {
  public static Long getSumOfList(List<Long> numbers) {
    if (numbers.isEmpty()) {
      return 0L;
    }
    if (numbers.size() < 2) {
      return numbers.get(0);
    }
    List<Long> copyNumbers = numbers.subList(0,numbers.size());
    Long a = copyNumbers.remove(copyNumbers.size() - 1);
    Long b = copyNumbers.remove(copyNumbers.size() - 1);
    copyNumbers.add(a+b);
    return getSumOfList(copyNumbers);
  }

  public static void main(String[] args) {
    List<Long> testNums = new ArrayList<>();
    testNums.add(2L);
    testNums.add(20L);
    testNums.add(200L);
    testNums.add(2000L);

    System.out.println(getSumOfList(testNums));
  }
}
