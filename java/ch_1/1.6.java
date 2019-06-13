class Main {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.err.printf("usage: compress arg1\n  arg1: string to compress\n");
    } else {
      System.out.println(compress(args[0]));
    }
  }

  // time complexity O(p + k^2) where p = length of string and k = number of character sequences
  // space complexity O(p)
  static String compress(String str) {
    String compressed = "";
    int count = 0;
    for (int i = 0; i < str.length(); ++i) {
      ++count;
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressed += "" + str.charAt(i) + count;
        count = 0;
      }
    }
    return compressed.length() < str.length() ? compressed : str;
  }
}
