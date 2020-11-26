package com.gutucristian.Chapter1;

import java.util.Arrays;

class CheckPermutation {
  public static void main(String[] args) {
    String s = "abc";
    String t = "cba";
    System.out.println(permutation(s, t));
  }

  // time complexity O(n)
  // space complexity O(1)
  static boolean permutation(String s, String t) {
    if (s.length() != t.length()) return false; // O(n)
    int[] letters = new int[128]; // Assumption: ASCII
    for (int i = 0; i < s.length(); ++i) {
      ++letters[s.charAt(i)];
    }
    for (int i = 0; i < t.length(); ++i) {
      --letters[t.charAt(i)];
      if (letters[t.charAt(i)] < 0) return false;
    }
    return true;
  }

  // // time complexity O(nlogn)
  // // space complexity O(n)
  // static String sort(String str) {
  //   char[] content = str.toCharArray(); // O(n)
  //   // sorting primitive values makes use of dual pivot QuickSort which is O(nlogn) on average (in the worst case it is O(n^2))
  //   java.util.Arrays.sort(content);
  //   return new String(content); // O(n)
  // }

  // // time complexity O(nlogn)
  // // space complexity O(n)
  // static boolean permutation(String s, String t) {
  //   if (s.length() != t.length()) return false; // O(n)
  //   return sort(s).equals(sort(t)); // O(nlogn) + O(n) = O(nlogn)
  // }
}
