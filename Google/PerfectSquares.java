/**
 *	279. Perfect Squares
 *	https://leetcode.com/problems/perfect-squares/description/
 */
class PerfectSquares {

	/**
	 * Version 1: Use Dynamic Programming
	 *      Time: O(n^2)
	 *     Space: O(n)
	 */
	public int numSquares(int n) {
        if (n < 1) {
            return Integer.MIN_VALUE;
        }
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int square = (int) Math.sqrt(i);
            if (square * square == i) {
                dp[i] = 1;
                continue;
            }
            int count = dp[i - 1] + 1;
            for (int j = i - 1; j >= 1; --j) {
                int temp = dp[j] + dp[i - j];
                count = Math.min(count, temp);
            }
            dp[i] = count;
        }

        return dp[n];
    }
}