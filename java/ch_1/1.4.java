class Main {
  public static void main(String args[]) {
    String str = "cccjccc";
    System.out.println(isPermutationOfPalindrome(str)); 
  }

  // time complexity O(n)
  // space complexity O(1)
  static boolean isPermutationOfPalindrome(String str) {
    int bitVector = createBitVector(str);
    return bitVector == 0 || checkExactlyOneBitSet(bitVector);
  }

  // time complexity O(n)
  // space complexity O(1)
  static int createBitVector(String str) {
    int bitVector = 0; // int is 4 bytes so bitVector is a 32 bit bit vector
    for (char c: str.toCharArray()) {
      int x = getCharNumber(c);
      bitVector = toggle(bitVector, x);
    }
    return bitVector;
  }
  
  // time complexity O(1)
  // space complexity O(1)
  static int toggle(int bitVector, int index) {
    if (index < 0) return bitVector;
    int mask = 1 << index;
    if ((bitVector & mask) == 0) { // check that bit at index is not '1' in bitVector
      bitVector |= mask; // set bit at index to '1'
    } else { // bit at index in bitVector is '1'
      bitVector &= ~mask; // toggle bit at index in bitVector
    }
    return bitVector;
  }

  // time complexity O(1)
  // space complexity O(1)
  static boolean checkExactlyOneBitSet(int bitVector) {
    return (bitVector & (bitVector - 1)) == 0;
  }

  // time complexity O(n)
  // space complexity O(1)
  // static boolean isPermutationOfPalindrome(String str) {
  //   int countOdd = 0;
  //   int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
  //   for (char c: str.toCharArray()) {
  //     int x = getCharNumber(c);
  //     ++table[x];
  //     if ((table[x] & 1) == 1) { // value at table[x] is odd
  //       ++countOdd;
  //     } else {
  //       --countOdd;
  //     }
  //   }
  //   return countOdd <= 1;
  // }
  
  // // time complexity O(n)
  // // space complexity O(1)
  // static boolean isPermutationOfPalindrome(String str) {
  //   int[] table = buildCharFrequencyTable(str);
  //   return checkMaxOneOdd(table);
  // }

  // static boolean checkMaxOneOdd(int[] table) {
  //   boolean foundOdd = false;
  //   for (int count: table) {
  //     if (count % 2 == 1) {
  //       if (foundOdd) return false;
  //       foundOdd = true;
  //     }
  //   }
  //   return true;
  // }

  static int getCharNumber(Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(c);
    if (a <= val && val <= z) {
      return val - a;
    }
    return -1;
  }

  // static int[] buildCharFrequencyTable(String phrase) {
  //   int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
  //   for (char c: phrase.toCharArray()) {
  //     int x = getCharNumber(c);
  //     if (x != -1) { // x = -1 if c is not a char from a-z
  //       ++table[x];
  //     }
  //   }
  //   return table;
  // }
}
