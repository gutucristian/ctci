import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[][] matrix = {
      {4, 5, 1},
      {9, 4, 6},
      {7, 3, 2}
    };
    System.out.println("Original:");
    printMatrix(matrix);
    rotateMatrix(matrix);
    System.out.println("Final:");
    printMatrix(matrix);
  }

  static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = 0; j < matrix[i].length; ++j) {
        System.out.printf("%3d", matrix[i][j]);
      }
      System.out.println();
    }
  }

  // in place transpose
  static void transpose(int[][] matrix) {
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = i+1; j < matrix.length; ++j) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    } 
  }

  // transpose then rotate matrix about middle column for 90 degree clockwise rotation
  static void rotateAboutMiddleColumn(int[][] matrix) {
    for (int i = 0; i < matrix.length / 2; ++i) {
      for (int j = 0; j < matrix.length; ++j) {
        int tmp = matrix[j][i];
        matrix[j][i] = matrix[j][matrix.length-1-i];
        matrix[j][matrix.length-1-i] = tmp;
      }
    }
  }

  // transpose then rotate matrix about middle row for 90 degree counter clockwise rotation
  private static void rotateAboutMiddleRow(int[][] matrix) {
    int len = matrix.length;
    for(int i = 0; i < len/2; i++){
      for(int j = 0;j < len; j++){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[len-1 -i][j];
        matrix[len -1 -i][j] = temp;
      }
    }
  }

  // time complexity O(n)
  // space complexity O(1)
  public static void rotateMatrix(int[][] matrix){
    if(matrix == null) return;
    if(matrix.length != matrix[0].length) return; // invalid input
    transpose(matrix); // time complexity O(n)
    rotateAboutMiddleColumn(matrix); // time complexity O(n)
  }
}
  
// static boolean rotate(int[][] m) {
//   if (m.length == 0 || m.length != m[0].length) {
//     return false;
//   }

//   for (int layer = 0; layer < m.length / 2; layer++) { // an NxN matrix has m.length/2 layers
//     for (int i = layer; i < m.length-1-layer; i++) { // iterate through elements of each layer and rotate
//       int c1 = m[layer][i]; // top left corner
//       int c2 = m[i][m.length-layer-1]; // top right corner
//       int c3 = m[m.length-layer-1][m.length-i-1]; // bottom right corner
//       int c4 = m[m.length-i-1][layer]; // bottom left corner

//       m[layer][i] = c4; // move bottom left element to top left
//       m[i][m.length-layer-1] = c1; // move top left element to top right
//       m[m.length-layer-1][m.length-i-1] = c2; // move top right element to bottom right
//       m[m.length-i-1][layer] = c3; // move bottom right element to bottom left
//     }
//   }

//   return true;
// }
