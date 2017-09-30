import java.util.*;

/**
 * Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example: "abcacb" --> "abc"
 *   		"bbbb"   --> "b"
 *
 */
class LongestSubstringWithoutRepeatingCharacters {
	
	/**
     * Version 1: Use two pointers and a HashSet
     *      Time: O(n)
     *     Space: O(n)
     */
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Set<Character> set = new HashSet<Character>();
		int start = 0;
		int end = 0;
		int length = 1;
		while (end < s.length()) {
			if (!set.contains(s.charAt(end))) {
				set.add(s.charAt(end++));
				length = Math.max(length, end - start);
			} else {
				set.remove(s.charAt(start++));
			}
		}
		return length;
	}

	/**
     * Version 2: Use two pointers and a HashMap which records the index position
     *      Time: O(n)
     *     Space: O(n)
     */
	public static int lengthOfLongestSubstringMap(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int length = 1;
		int start = 0;
		int end = 0;
		while (end < s.length()) {
			if (!map.containsKey(s.charAt(end))) {
				map.put(s.charAt(end), end);
			} else if (map.get(s.charAt(end)) < start){
				map.remove(s.charAt(end));
				map.put(s.charAt(end), end);
			} else {
				start = map.get(s.charAt(end)) + 1;
				map.remove(s.charAt(end));
				map.put(s.charAt(end), end);
			}
			end++;
			length = Math.max(length, end - start);
		}

		return length;
	} 

	public static void main(String[] argv) {
		System.out.println("Length: " + lengthOfLongestSubstringMap("abcabcbb"));
		System.out.println("Length: " + lengthOfLongestSubstringMap("bbbb"));
		System.out.println("Length: " + lengthOfLongestSubstringMap("aab"));
	}
}