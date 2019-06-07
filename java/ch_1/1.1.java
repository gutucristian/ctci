class Main {
  public static void main(String[] args) {
    String str = "Boreal";
    boolean isUnique = isUniqueChars(str);
    System.out.println(isUnique);
  }
  
  static boolean isUniqueChars(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); ++i) {
      int val = str.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) return false;
      checker |= (1 << val);
    }
    return true;
  }

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
