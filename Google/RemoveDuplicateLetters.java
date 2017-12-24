/**
 *	316. Remove Duplicate Letters
 *	https://leetcode.com/problems/remove-duplicate-letters/description/
 */
class RemoveDuplicateLetters {

	/**
	 * Version 1: Use HashMap and stack
	 *      Time: O(n) -> Every character will be pushed and popped once respectively
	 *     Space: O(n)
	 */
	public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        HashMap<Character, Integer> map = new HashMap();
        HashSet<Character> set = new HashSet();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.size() == 0) {
                stack.push(c);
                set.add(c);
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            } else if (set.contains(c)) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            } else {
                while (stack.size() != 0 && map.containsKey(stack.peek()) && stack.peek() - c > 0) {
                    set.remove(stack.pop());
                }

                stack.push(c);
                set.add(c);
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}