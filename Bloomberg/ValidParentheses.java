/**
 *	20. Valid Parentheses
 *	https://leetcode.com/problems/valid-parentheses/description/
 */
class ValidParentheses {

	/**
	 * Version 1: Use stack to keep left-side and try to make pairs
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		Stack<Character> stack = new Stack();
		Set<Character> leftSet = new HashSet<Character>();
		Set<Character> rightSet = new HashSet<Character>();

		leftSet.add('(');
		leftSet.add('{');
		leftSet.add('[');
		rightSet.add(')');
		rightSet.add('}');
		rightSet.add(']');

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (leftSet.contains(c)) {
				stack.push(c);
			} else if (rightSet.contains(c)) {
				if (stack.size() == 0) {
					return false;
				}
				char left = stack.pop();
				if ((c == ')' && left == '(') || (c == '}' && left == '{') || (c == ']' && left == '[')) {
					continue;
				} else {
					return false;
				}
			}
		}

		return stack.size() > 0 ? false : true;
	}
}