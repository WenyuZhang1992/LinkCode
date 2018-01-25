/**
 *	72. Edit Distance
 *	https://leetcode.com/problems/edit-distance/description/
 */
class EditDistance {

	/**
	 * Version 1: Use Dynamic Programming;
	 *      Time: O(m * n)
	 *     Space: O(m * n)
	 */
	public int minDistance(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < dp.length; ++i) {
            dp[i][0] = i;
        }
        for (int j = 1; j < dp[0].length; ++j) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); ++i) {
            for (int j = 1; j <= word2.length(); ++j) {
                int diff = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;

                // When delete a character in word1
                int dp1 = 1 + dp[i - 1][j];

                // When insert a character in word1
                int dp2 = 1 + dp[i][j - 1];

                // When remain the same or replace a character
                int dp3 = diff + dp[i - 1][j - 1];
                dp[i][j] = Math.min(Math.min(dp1, dp2), dp3);
            }
        }

        return dp[word1.length()][word2.length()];
    }
}