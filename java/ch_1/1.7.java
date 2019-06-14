import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[][] matrix = {
      {4, 5, 1, 0},
      {9, 4, 6, 3},
      {7, 3, 2, 1}
    };
    printMatrix(matrix);
    int[][] transpose = transpose(matrix);
    System.out.println("Transpose:");
    printMatrix(transpose);
    System.out.println("Reverse column order:");
    reverseColOrder(transpose);
    printMatrix(transpose);

    // int[][] matrix = new int[][]{
    //   {2, 3, 5, 4},
    //   {7, 14, 9, 0},
    //   {1, 6, 20, 3},
    //   {16, 3, 7, 5}
    // };  

    // System.out.printf("Original matrix: \n");
    // printMatrix(matrix);
    // rotate(matrix);
    // System.out.printf("Rotated matrix: \n");
    // printMatrix(matrix);
  }

  static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = 0; j < matrix[i].length; ++j) {
        System.out.printf("%3d", matrix[i][j]);
      }
      System.out.println();
    }
  }

  static int[][] transpose(int[][] matrix) {
    int[][] transpose = new int[matrix[0].length][matrix.length];
    // System.out.printf("transpose is a %dx%d matrix\n", matrix.length, matrix.length);
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = 0; j < matrix[i].length; ++j) {
        // System.out.printf("i=%d, j=%d\n", i, j);
        transpose[j][i] = matrix[i][j];
      }
    } 

    return transpose;
  }

  static void reverseColOrder(int[][] matrix) {
    System.out.printf("matrix dimension is %dx%d\n", matrix.length, matrix[0].length);
    for (int i = 0; i < matrix[0].length / 2; ++i) {
      for (int j = 0; j < matrix.length; ++j) {
        System.out.printf("i=%d, j=%d\n", i, j);
        int tmp = matrix[j][i];
        matrix[j][i] = matrix[j][matrix[j].length-1-i];
        matrix[j][matrix[j].length-1-i] = tmp;
      }
    }
  }

  static boolean rotate(int[][] m) {
    if (m.length == 0 || m.length != m[0].length) {
      return false;
    }    

    for (int layer = 0; layer < m.length / 2; layer++) { // an NxN matrix has m.length/2 layers
      for (int i = layer; i < m.length-1-layer; i++) { // iterate through elements of each layer and rotate
        int c1 = m[layer][i]; // top left corner
        int c2 = m[i][m.length-layer-1]; // top right corner
        int c3 = m[m.length-layer-1][m.length-i-1]; // bottom right corner
        int c4 = m[m.length-i-1][layer]; // bottom left corner

        m[layer][i] = c4; // move bottom left element to top left
        m[i][m.length-layer-1] = c1; // move top left element to top right
        m[m.length-layer-1][m.length-i-1] = c2; // move top right element to bottom right
        m[m.length-i-1][layer] = c3; // move bottom right element to bottom left
      }
    }

    return true;
  }
}
