class Main {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("usage: isOneEditAway a b");
    } else {
      System.out.printf("a=%s, b=%s\n", args[0], args[1]);
      // System.out.println(isOneEditAway(args[0], args[1], false));
      System.out.println(isOneEditAway(args[0], args[1]));
    }
  }

  // time complexity O(n)
  // space complexity O(1)
  static boolean isOneEditAway(String a, String b) {
    if (Math.abs(a.length() - b.length()) > 1) return false;

    String s1 = a.length() < b.length() ? a : b; // O(1) space complexity (s1 points to a or b, it does not make a copy, reason: Java String pool)
    String s2 = a.length() < b.length() ? b : a; // O(1) space complexity (s2 points to a or b, it does not make a copy)
  
    // System.out.printf("(s1 == a) %b\n", s1 == a);
    // System.out.printf("(s1 == b) %b\n", s1 == b);
    // System.out.printf("(s2 == a) %b\n", s2 == a);
    // System.out.printf("(s2 == b) %b\n", s2 == b);
    
    int i = 0, j = 0;
    boolean foundDifference = false;

    while (j < s2.length() && i < s1.length()) {
      if (s1.charAt(i) != s2.charAt(j)) {
        if (foundDifference) return false;
        foundDifference = true;
        if (s1.length() == s2.length()) {
          ++i;
        }
      } else {
        ++i;
      }
      ++j;
    }    
    
    return true;
  }

  // static boolean isOneEditAway(String a, String b) {
  //   if (a.length() == b.length()) {
  //     return oneEditReplace(a, b);
  //   } else if (a.length() + 1 == b.length()) {
  //     return oneEditInsert(a, b);
  //   } else if (a.length() - 1 == b.length()) {
  //     return oneEditInsert(b, a);
  //   }
  //   return false;
  // }

  // static boolean oneEditReplace(String a, String b) {
  //   boolean oneEdit = false;
  //   for (int i = 0; i < a.length(); ++i) {
  //     if (a.charAt(i) != b.charAt(i)) {
  //       if (oneEdit) return false;
  //       oneEdit = true;
  //     }
  //   }
  //   return true;
  // }

  // static boolean oneEditInsert(String a, String b) {
  //   boolean oneInsert = false;
  //   int i = 0, j = 0;
  //   while (i < a.length()) {
  //     if (a.charAt(i) != b.charAt(j)) {
  //       if (oneInsert) return false;
  //       oneInsert = true;
  //       ++j;
  //     } else {
  //       ++i;
  //       ++j;
  //     }
  //   }
  //   return true;
  // }

  // static boolean isOneEditAway(String a, String b, boolean oneEdit) {
  //   if (Math.abs(a.length() - b.length()) > 1) return false;
  //   if (a.length() == 1 && b.length() == 1) {
  //     if (oneEdit) return false;
  //     if (a.equals(b)) return true;
  //     return true;
  //   }
  //   if (a.length() == 0 || b.length() == 0) {
  //     if (Math.abs(a.length() - b.length()) == 1 && !oneEdit) return true;
  //     return false;
  //   }
  //   if (a.substring(0, 1).equals(b.substring(0, 1))) return isOneEditAway(a.substring(1), b.substring(1), oneEdit);
  //   return isOneEditAway(a.substring(1), b, true) || isOneEditAway(a, b.substring(1), true);
  // }
}
