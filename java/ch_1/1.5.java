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

  static boolean isOneEditAway(String a, String b) {
    if (a.length() == b.length()) {
      return oneEditReplace(a, b);
    } else if (a.length() + 1 == b.length()) {
      return oneEditInsert(a, b);
    } else if (a.length() - 1 == b.length()) {
      return oneEditInsert(b, a);
    }
    return false;
  }

  static boolean oneEditReplace(String a, String b) {
    boolean oneEdit = false;
    int i = 0, j = 0;
    while (i < a.length()) {
      if (a.charAt(i) != b.charAt(j)) {
        if (oneEdit) return false;
        oneEdit = true;
      }
      ++i;
      ++j;
    }
    return true;
  }

  static boolean oneEditInsert(String a, String b) {
    boolean oneInsert = false;
    int i = 0, j = 0;
    while (i < a.length()) {
      if (a.charAt(i) != b.charAt(j)) {
        if (oneInsert) return false;
        oneInsert = true;
        ++j;
      } else {
        ++i;
        ++j;
      }
    }
    return true;
  }

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
