import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    String str = "Mr John Smith    ";
    char[] tmp = str.toCharArray();
    replaceSpaces(tmp, 13);
    System.out.println(Arrays.toString(tmp));
  }

  // time complexity O(n)
  // space complexity O(1)
  public static void replaceSpaces(char[] str, int trueLength) {
    // count number of spaces
    int spaceCount = 0;
    for (int i = 0; i < trueLength; ++i) { // O(n)
      if (str[i] == ' ') ++spaceCount;
    }
    // could also do ((spaceCount * 3) - spaceCount) but that is same as (spaceCount * 2)
    int index = trueLength + spaceCount * 2; // calculate required length
    for (int i = trueLength - 1; i >= 0; --i) { // O(n)
      if (str[i] == ' ') {
        str[--index] = '0';
        str[--index] = '2';
        str[--index] = '%';
      } else {
        str[--index] = str[i];
      }
    }
  }
}
