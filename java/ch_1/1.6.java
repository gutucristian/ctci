class Main {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.err.printf("usage: compress arg1\n  arg1: string to compress\n");
    } else {
      System.out.println(compress(args[0]));
    }
  }

  // time complexity O(p) where p = length of string
  // space complexity O(1)
  static int countCompression(String str) {
    int compressedLength = 0;
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); ++i) {
      ++countConsecutive;
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressedLength += 1 + String.valueOf(countConsecutive).length();
        countConsecutive = 0;
      }
    }
    return compressedLength;
  }

  // time complexity O(p + k) where p = length of string and k = number of elements in "compressed" StringBuilder object
  // space complexity O(p)
  static String compress(String str) {
    int finalLength = countCompression(str);
    if (finalLength >= str.length()) return str;
    
    int countConsecutive = 0;
    StringBuilder compressed = new StringBuilder(finalLength);
    for (int i = 0; i < str.length(); ++i) {
      ++countConsecutive;
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressed.append(str.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }

    return compressed.toString();
  }

  // time complexity O(p + k) where p = length of string and k = number of character sequences
  // space complexity O(p)
  // static String compress(String str) {
  //   StringBuilder compressed = new StringBuilder();
  //   int count = 0;
  //   for (int i = 0; i < str.length(); ++i) {
  //     ++count;
  //     if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
  //       compressed.append(str.charAt(i));
  //       compressed.append(count);
  //       count = 0;
  //     }
  //   }
  //   return compressed.length() < str.length() ? compressed.toString() : str;
  // }

  // time complexity O(p + k^2) where p = length of string and k = number of character sequences
  // space complexity O(p)
  // static String compress(String str) {
  //   String compressed = "";
  //   int count = 0;
  //   for (int i = 0; i < str.length(); ++i) {
  //     ++count;
  //     if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
  //       compressed += "" + str.charAt(i) + count;
  //       count = 0;
  //     }
  //   }
  //   return compressed.length() < str.length() ? compressed : str;
  // }
}
