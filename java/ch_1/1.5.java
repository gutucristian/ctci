class Main {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("usage: isOneEditAway a b");
    } else {
      System.out.printf("a=%s, b=%s\n", args[0], args[1]);
      System.out.println(isOneEditAway(args[0], args[1], false));
    }
  }

  static boolean isOneEditAway(String a, String b, boolean oneEdit) {
    if (Math.abs(a.length() - b.length()) > 1) return false;
    if (a.length() == 1 && b.length() == 1) {
      if (oneEdit) return false;
      if (a.equals(b)) return true;
      return true;
    }
    if (a.length() == 0 || b.length() == 0) {
      System.out.printf("a = %s, b = %s, oneEdit = %b\n", a, b, oneEdit);
      if (Math.abs(a.length() - b.length()) == 1 && !oneEdit) return true;
      return false;
    }
    if (a.substring(0, 1).equals(b.substring(0, 1))) return isOneEditAway(a.substring(1), b.substring(1), oneEdit);
    return isOneEditAway(a.substring(1), b, true) || isOneEditAway(a, b.substring(1), true);
  }
}
