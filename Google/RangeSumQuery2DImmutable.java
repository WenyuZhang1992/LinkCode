/**
 *	304. Range Sum Query 2D - Immutable
 *	https://leetcode.com/problems/range-sum-query-2d-immutable/solution/
 */

/**
 * Version 1: Use accumulative sum
 *            Construct a matrix that every element contains left sum of the array
 *            Given two nodes, we only need to calculate the left sum difference of each row
 *      Time: O(m) -> Row difference of the inputs
 *     Space: O(m*n)
 */
class NumMatrix {

    int[][] dp;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        dp = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                dp[i][j + 1] = matrix[i][j] + dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; ++i) {
            result += (dp[i][col2 + 1] - dp[i][col1]);
        }
        return result;
    }
}

/**
 * Version 2: Use accumulative sum
 *            Construct a matrix that every element contains the sum of elements in the rectangular 
 *            constructed by this position and original as two diagonal nodes
 *      Time: O(1) -> Row difference of the inputs
 *     Space: O(m*n)
 */
class NumMatrix {

    int[][] dp;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                dp[i + 1][j + 1] = matrix[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}

