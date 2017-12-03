/**
 *	17. Letter Combinations of a Phone Number
 *	https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
class LetterCombinationsOfPhoneNumber {

	/**
	 * Version 1: Use DFS
	 *      Time: O(4^n) -> the upper bound of character in one digits is 4 and assume totally n digits
	 *     Space: 
	 */
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}

		HashMap<Character, char[]> map = new HashMap();
		map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'q', 'p', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});

		StringBuilder sb = new StringBuilder();
		letterCombinations(digits, sb, map, result);
		return result;
	}

	private void letterCombinations(String digits, StringBuilder sb, HashMap<Character, char[]> map, List<String> result) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}
		int index = sb.length();
		char[] chars = map.get(digits.charAt(index));
		for (int i = 0; i < chars.length; i++) {
			sb.append(chars[i]);
			letterCombinations(digits, sb, map, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}