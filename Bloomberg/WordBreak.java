/**
 *	139. Word Break
 *	https://leetcode.com/problems/word-break/description/
 */
class WordBreak {

	/**
	 * Version 1: Use DP
	 *      Time: O(n^2)
	 *     Space: O(n)
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }
}