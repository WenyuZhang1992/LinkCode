/**
 *	Find if given matrix is Toeplitz or not:
 *	Given a square matrix, find if it’s a Toeplitz matrix or not. 
 *  A Toeplitz (or diagonal-constant) matrix is a matrix in which each descending diagonal from left to right is constant, 
 *  i.e., all elements in a diagonal are same.
 */
class ToeplitzMatrix {

    /**
	 * Version 1: From the first row and column respectively to check the diagonals
	 *      Time: O(m*n) -> Need to traverse each element
	 *     Space: O(1)
	 *  Followup: What if the matrix is too large?
	 *            Move scanning window
	 */
	public boolean isToepliz(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int M = matrix.length;
        int N = matrix[0].length;

        // Check first row
        for (int i = 0; i < M - 1; ++i) {
            if (!checkDiagonal(matrix, i, 0, matrix[i][0])) {
                return false;
            }
        }

        // Check first column
        for (int j = 1; j < M - 1; ++j) {
            if (!checkDiagonal(matrix, 0, j, matrix[0][j])) {
                return false;
            }
        }

        return true;
    }

    private boolean checkDiagonal(int[][] matrix, int i, int j, int value) {
        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] != value) {
                return false;
            }
            ++i;
            ++j;
        }

        return true;
    }
}