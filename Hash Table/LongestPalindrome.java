import java.util.*;

/**
 * Longest Palindrome
 *
 * Given a string which consists of lowercase or uppercase letters, 
 * find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 */
class LongestPalindrome {
	
	/**
     * Version 1: Use Hash Table to store occur frequency of characters
     *      Time: O(n)
     *     Space: O(n)
     */
	public static int longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		HashMap<Character, Integer> map = new HashMap();
		for (int i=0; i<s.length(); i++) {
			char temp = s.char(i);
			if (map.containsKey(temp)) {
				int value = map.get(temp);
				map.put(temp, value + 1);
			} else {
				map.put(temp, 1);
			}
		}

		int result = 0;
		boolean hasSingle = false;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			int temp = entry.getValue();
			if (temp % 2 == 0) {
				result += temp;
			} else if (temp == 1) {
				hasSingle = true;
			} else {
				result += temp - 1;
				hasSingle = true;
			}
		}

		return hasSingle ? result + 1 : result;

	}

	public static void main(String[] argv) {
		System.out.println(longestPalindrome("abccccdd"));
	}
}