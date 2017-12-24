/**
 *	680. Valid Palindrome II
 *	https://leetcode.com/problems/valid-palindrome-ii/description/
 */
class ValidPalindromeII {

	/**
	 * Version 1: Use Two Pointers
	 *      Time: O(n) -> Only traverse the array once
	 *     Space: O(1)
	 */
	public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return false;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            ++j;
        }
        return true;
    }
}