class Main {
  public static void main(String args[]) {
    String str = "cccjccc";
    System.out.println(isPermutationOfPalindrome(str)); 
  }
  
  static boolean isPermutationOfPalindrome(String str) {
    int[] table = buildCharFrequencyTable(str);
    return checkMaxOneOdd(table);
  }

  static boolean checkMaxOneOdd(int[] table) {
    boolean foundOdd = false;
    for (int count: table) {
      if (count % 2 == 1) {
        if (foundOdd) return false;
        foundOdd = true;
      }
    }
    return true;
  }

  static int getCharNumber(Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if (a <= val && val <= z) {
      return val - a;
    }
    return -1;
  }

  static int[] buildCharFrequencyTable(String phrase) {
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for (char c: phrase.toCharArray()) {
      int x = getCharNumber(c);
      if (x != -1) { // x = -1 if c is not a char from a-z
        ++table[x];
      }
    }
    return table;
  }
}
