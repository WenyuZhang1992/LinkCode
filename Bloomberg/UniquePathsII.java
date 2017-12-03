/**
 *	63. Unique Paths II
 *	https://leetcode.com/problems/unique-paths-ii/description/
 */
class UniquePathsII {

	/**
	 * Version 1: Use Dynamic Programming
	 *      Time: O(m*n)
	 *     Space: O(m*n)
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}

		int M = obstacleGrid.length;
		int N = obstacleGrid[0].length;
		int[][] dp = new int[M][N];
		dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		for (int i = 1; i < M; i++) {
			if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = 1;
			}
		}
		for (int i = 1; i < N; i++) {
			if (obstacleGrid[0][i] == 1 || dp[0][i - 1] == 0) {
				dp[0][i] = 0;
			} else {
				dp[0][i] = 1;
			}
		}

		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[M - 1][N - 1];
	}
}