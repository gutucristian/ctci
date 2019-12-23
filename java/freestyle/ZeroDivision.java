import java.lang.IllegalArgumentException;

class Main {
  static void divide(int num, int den) throws IllegalArgumentException{
    if (den == 0) {
      throw new IllegalArgumentException("Denominator is 0!");
    }
    double res = 0;
    res /= num / den;
  }

  static void fun() {
    try {
      divide(4, 0);
    } catch (IllegalArgumentException e) {
      // System.out.println() is buffered
      // System.err.println() is not!
      System.err.println("Error: " + e);
    }
  }

  public static void main(String[] args) {
    // divide(4, 0);
    fun();
  }
}