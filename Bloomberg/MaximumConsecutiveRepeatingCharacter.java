/**
 *	Maximum consecutive repeating character in string
 *	Given a string, the task is to find maximum consecutive repeating character in string.
 */
class MaximumConsecutiveRepeatingCharacter {

	/**
	 * Version 1: Use Two Pointers
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public char maxRepeating(String str) {
		if (str.length() == 1) {
			return str.charAt(0);
		}

		char candidate = str.charAt(0);
		int maxLength = 1;
		int start = 0;
		int end = 0;

		while (start < str.length() && end < str.length()) {
			if (str.charAt(end) == str.charAt(start)) {
				end++;
				continue;
			}
			if (maxLength < (end - start)) {
				maxLength = end - start;
				candidate = str.charAt(start);
			}
			start = end;
		}

		// Need to check the last character since it's not updated
		if (maxLength < (end - start)) {
			maxLength = end - start;
			candidate = str.charAt(start);
		}

		return candidate;
	}
}