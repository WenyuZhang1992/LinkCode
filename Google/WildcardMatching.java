/**
 *	44. Wildcard Matching
 *	https://leetcode.com/problems/wildcard-matching/description/
 */
class WildcardMatching {

    /**
	 * Version 1: Use Dynamic Programming.
     *            dp[i][j] stands for characters 0 -> (i-1) of s matches characters 0 -> (j-1) of p
	 *      Time: O(m*n) -> m is the length of string s, n is the length of string p
	 *     Space: O(m*n)
	 */
	public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return false;
        }

        int M = s.length();
        int N = p.length();
        boolean[][] dp = new boolean[M + 1][N + 1];

        dp[0][0] = true;
        // Deal with empty string of s
        for (int j = 1; j <= N; ++j) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (p.charAt(j - 1) == '*') {
                    // dp[i][j]  = dp[i-1][j] || dp[i-1][j-1] || dp[i-1][j-2] ... || dp[i-1][0]
                    // can be simplified to dp[i][j] = dp[i-1][j] || dp[i][j]
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[M][N];
    }
}