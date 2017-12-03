/**
 *	3. Longest Substring Without Repeating Characters
 *	https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * Version 1: Use HashTable to keep track of the character and its up-to-date index
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int length = 1;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, i);
				length = Math.max(length, i - start + 1);
			} else {
				if (map.get(c) < start) {
					map.put(c, i);
					length = Math.max(length, i - start + 1);
				} else {
					length = Math.max(length, i - start);
					start = map.get(c) + 1;
					map.put(c, i);
				}
			}
		}

		return length;
	}
}