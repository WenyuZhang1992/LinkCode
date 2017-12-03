/**
 *	Find all distinct palindromic substrings of a given string
 *	Given a string of lowercase ASCII characters, find all distinct continuous palindromic sub-strings of it.
 *
 *  Example:
 *  Input: str = "abaaa"
 *  Output: Below are 5 palindrome sub-strings
 *  	    a
 *          aa
 *  		aaa
 *  		aba
 *  		b 
 */
class FindAllDistinctPalindromicSubstrings {

	/**
	 * Version 1: Use DP find all palindromes and put them into a HashSet
	 *      Time: O(n^2)
	 *     Space: O(n^2)
	 */
	public List<String> palindromeSubStrs(String s) {
		if (s == null || s.length() == 0) {
			return new ArrayList<String>();
		}

		List<String> result = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		boolean[][] dp = new boolean[s.length()][s.length()];

		for (int l = 0; l < s.length(); l++) {
			for (int i = 0; i + l < s.length(); i++) {
				int j = i + l;
				if (s.charAt(i) == s.charAt(j) && ((j - i) < 2 || dp[i+1][j-1])) {
					dp[i][j] = true;
					set.add(s.substring(i, j + 1));
				}
			}
		}

		for (String str : set) {
			result.add(str);
		}

		return result;
	}
}