/**
 *	125. Valid Palindrome
 *	https://leetcode.com/problems/valid-palindrome/description/
 */
class ValidPalindrome {
	
	/**
	 * Version 1: Use Two Pointers
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        } 
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            while (start < s.length() && !isValid(s.charAt(start))) {
                start++;
            }
            
            if (start == s.length()) {
                return true;
            }
            
            while (end >= 0 && !isValid(s.charAt(end))) {
                end--;
            }
            
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        
        return true;
    }
    
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}