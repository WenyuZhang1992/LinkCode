/**
 *	311. Sparse Matrix Multiplication
 *	Given two sparse matrices A and B, return the result of AB.
 *  You may assume that A's column number is equal to B's row number.
 */
class SparseMatrixMultiplication {
	
	/**
	 * Version 1: Check if A[i][j] == 0; if not, add element multiplication value to all positions need A[i][j]
	 *      Time: O(n*m*l) -> n = rowNumber of A, m -> colNumber of A, l -> colNumber of B
	 *     Space: O(1)
	 */
	public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null) {
            return new int[0][0];
        }

        int aRow = A.length;
        int aCol = A[0].length;
        int bCol = B[0].length;

        int[][] C = new int[aRow][bCol];

        for (int i=0; i < aRow; i++) {
            for (int j = 0: j < aRow; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < bCol; k++) {
                    C[i][k] += A[i][j] * B[j][k];
                }
            }
        }

        return C;
    }
}