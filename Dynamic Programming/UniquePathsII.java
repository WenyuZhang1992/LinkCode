/**
 *	63. Unique Paths II
 *	https://leetcode.com/problems/unique-paths-ii/description/
 */
class UniquePathsII {
	
	/**
	 * Version 1: Use DP
	 *      Time: O(n*m)
	 *     Space: O(n*m)
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        // Initialize
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i=1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int j=1; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j-1];
            }
        }
        
        for (int x = 1; x < obstacleGrid.length; x++) {
            for (int y = 1; y < obstacleGrid[0].length; y++) {
                if (obstacleGrid[x][y] == 1) {
                    dp[x][y] = 0;
                } else {
                    dp[x][y] = dp[x-1][y] + dp[x][y-1];
                }
            }
        }
        
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}