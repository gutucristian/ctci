package com.gutucristian.Chapter1;

import java.util.Arrays;

class ZeroMatrix {
	public static void main(String[] args) {
		int[][] m = {
			{2, 3, 1, 0},
			{7, 5, 8, 4},
			{0, 6, 4, 9},
			{8, 3, 5, 7}
		};
		printMatrix(m);
		zeroMatrix(m);
		printMatrix(m);
	}

	public static void zeroRow(int[][] m, int r) {
    Arrays.fill(m[r], 0);
//    for (int i = 0; i < m[r].length; i++) {
//      m[r][i] = 0;
//    }
	}

	public static void zeroCol(int[][] m, int c) {
		for (int i = 0; i < m.length; i++) {
			m[i][c] = 0;
		}
	}

	public static void zeroMatrix(int[][] m) {
		boolean rowHasZero = false;
		boolean colHasZero = false;

		// check if first row has zero
		for (int i = 0; i < m[0].length; i++) {
      if (m[0][i] == 0) {
        rowHasZero = true;
        break;
      }
		}

		// check if first col has zero
    for (int[] ints : m) {
      if (ints[0] == 0) {
        colHasZero = true;
        break;
      }
    }

//    for (int i = 0; i < m.length; i++) {
//      if (m[i][0] == 0) {
//        colHasZero = true;
//        break;
//      }
//    }

		// mark which cols and rows need to be zeroed
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 0) {
					m[i][0] = 0;
					m[0][j] = 0;
				}
			}
		}

		// zero cols
		for (int i = 1; i < m[0].length; i++) {
			if (m[0][i] == 0) {
				zeroCol(m, i);
			}
		}

		// zero rows
		for (int i = 1; i < m.length; i++) {
			if (m[i][0] == 0) {
				zeroRow(m, i);
			}
		}

		if (rowHasZero) {
			zeroRow(m, 0);
		}

		if (colHasZero) {
			zeroCol(m, 0);
		}
	}

	public static void printMatrix(int[][] m) {
    for (int[] ints : m) {
      for (int anInt : ints) {
        System.out.printf("%3d", anInt);
      }
      System.out.printf("\n");
    }
	}
}
