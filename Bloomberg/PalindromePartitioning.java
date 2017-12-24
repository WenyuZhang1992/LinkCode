/**
 *	131. Palindrome Partitioning
 *	https://leetcode.com/problems/palindrome-partitioning/description/
 */
class PalindromePartitioning {

	/**
	 * Version 1: Use DFS and backtracking
	 *			  Firstly use DP to obtain a palindrome matrix
	 *      Time: O(2^n)
	 *     Space: O(n^2)
	 */
	public List<List<String>> partition(String s) {
        List result = new ArrayList();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        
        helper(s, result, dp, 0, new ArrayList<String>());
        return result;
    }
    
    private void helper(String s, List result, boolean[][] dp, int start, ArrayList<String> list) {
        if (start >= s.length()) {
            result.add(new ArrayList<String>(list));
        }
        
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                list.add(s.substring(start, i + 1));
                helper(s, result, dp, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}