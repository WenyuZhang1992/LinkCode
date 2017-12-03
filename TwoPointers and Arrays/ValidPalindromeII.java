/**
 *	680. Valid Palindrome II
 *	https://leetcode.com/problems/valid-palindrome-ii/description/
 */
class ValidPalindromeII {
	
	/**
	 * Version 1: Use two pointers
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public boolean validPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            } else {
                ++start;
                --end;
            }
        }
        
        return true;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        
        return true;
    }
}