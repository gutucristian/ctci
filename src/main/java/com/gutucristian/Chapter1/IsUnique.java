package com.gutucristian.Chapter1;

class IsUnique {
  public static void main(String[] args) {
    String str = "Boreal";
//    boolean isUnique = isUniqueChars(str);
//    System.out.println(isUnique);
  }

//  static boolean isUniqueChars(String str) {
//
//  }

  // time complexity O(n^2)
  // space complexity O(1)
  // static boolean isUniqueChars(String str) {
  //   for (int i = 0; i < str.length() - 1; ++i) {
  //     for (int j = i + 1; j < str.length(); ++j) {
  //       // charAt() returns a char (which is a primitive type) at some index (i and j in this case)
  //       // since chars are primitive types we can use == to compare for equality. For reference types (e.g., String)
  //       // we must use the equals() method.
  //       if (str.charAt(i) == str.charAt(j)) {
  //         return false;
  //       }
  //     }
  //   }
  //   return true;
  // }

  // time complexity O(1)
  // space complexity O(1) (assumes a-z alphabet ONLY)
  //static boolean isUniqueChars(String str) {
  //  int checker = 0;
  //  for (int i = 0; i < str.length(); ++i) {
  //    int val = str.charAt(i) - 'a';
  //    if ((checker & (1 << val)) > 0) return false;
  //    checker |= (1 << val);
  //  }
  //  return true;
  //}

  // time complexity O(1) (is we assume ASCII character set)
  // space complexity O(1) (we use a fixed size array)
  //static boolean isUniqueChars(String str) {
  //  if (str.length() > 128) return false;
  //  boolean[] charSet = new boolean[128];
  //  for (int i = 0; i < str.length(); ++i) {
  //    int val = str.charAt(i);
  //    if (charSet[val]) return false;
  //    charSet[val] = true;
  //  }
  //  return true;
  //}
}
