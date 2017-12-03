/**
 *	
 */
class PalindromeSubstringCount {

	/** Version 1: Use DP, find out all Palindromes and traverse the 2-D array to get their count
     *       Time: O(n^2)
     *      Space: O(n^2)
     */
    public int CountPS(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }

        boolean[][] dp = new boolean[str.length()][str.length()];
        for (int l = 0; l < str.length(); l++) {
            for (int i = 0; i < str.length() - l; i++) {
                int j = i + l;
                if (str.charAt(i) == str.charAt(j) && ((j - i <= 2) || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (dp[i][j]) { count++; }
            }
        }

        return count;
    }
}