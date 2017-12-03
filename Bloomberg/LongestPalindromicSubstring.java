/**
 *	5. Longest Palindromic Substring
 *	https://leetcode.com/problems/longest-palindromic-substring/description/
 */
class LongestPalindromicSubstring {

	/**
	 * Version 1: Use Dynamic Programming
	 *      Time: O(n^2)
	 *     Space: O(n^2)
	 */
	public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
        	return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLength = 1;
        String result = s.substring(0, 1);
        for (int l = 0; l < s.length(); l++) {
        	for (int i = 0; i + l < s.length(); i++) {
        		int j = i + l;
        		if (s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i+1][j-1])) {
        			dp[i][j] = true;
        			if (j - i + 1 > maxLength) {
        				maxLength = j - i + 1;
        				result = s.substring(i, j + 1);
        			}
        		}
        	}
        }

        return result;
    }

    /**
	 * Version 2: Expand around center
	 *      Time: O(n^2)
	 *     Space: O(1)
	 */
	public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
        	return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
        	int length1 = expand(s, i, i);
        	int length2 = expand(s, i, i + 1);
        	int length = Math.max(length1, length2);
        	if (end - start < length) {
        		start = i - (length - 1) / 2;
        		end = i + length / 2;
        	}
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
    	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    		left--;
    		right++;
    	}

    	return right - left - 1;
    }
}