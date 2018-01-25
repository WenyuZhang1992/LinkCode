/**
 *	LintCode 92. Backpack
 *	http://www.lintcode.com/en/problem/backpack/
 */
class Backpack {

	/**
	 * Version 1: Use Dynamic Programming;
	 *      Time: O(m + n) -> n is the length of A
	 *     Space: O(m)
	 */
	public int backPack(int m, int[] A) {
        if (m <= 0) {
            return Integer.MIN_VALUE;
        }

        if (A == null || A.length == 0) {
            return 0;
        }

        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; ++i) {
            for (int j = m; j >= 0; --j) {
                if (j >= A[i]) {
                    dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
                }
            }
        }

        return dp[m];
    }
}