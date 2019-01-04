class Main {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{2, 3, 5, 4},
			{7, 14, 9, 0},
			{1, 6, 20, 3},
			{16, 3, 7, 5}
		};

		System.out.printf("Original matrix: \n");
		printMatrix(matrix);
		rotate(matrix);
		System.out.printf("Rotated matrix: \n");
		printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
			System.out.printf("\n");
		}
	}

	public static boolean rotate(int[][] m) {
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

