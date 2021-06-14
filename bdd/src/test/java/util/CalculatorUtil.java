package util;

public class CalculatorUtil {

  public int sum(int a, int b) {
    return a + b;
  }

  public int difference(int a, int b) {
    return a - b;
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public int divide(int a, int b) {
    if (a == 0) {
      System.out.println("Operation not allowed, can"
          + "t divide by 0");
      return 0;
    } else {
      return a / b;
    }
  }
}
