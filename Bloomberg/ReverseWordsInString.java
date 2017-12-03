/**
 *	151. Reverse Words in a String
 *	https://leetcode.com/problems/reverse-words-in-a-string/description/
 */
class ReverseWordsInString {

	/**
	 * Version 1: Use Two Pointers to traverse from the tail
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		int tail = s.length() - 1;
		int head = -1;
		StringBuilder sb = new StringBuilder();
		while (tail >= 0) {
			StringBuilder sb1 = new StringBuilder();
			while (tail >= 0 && Character.isSpace(s.charAt(tail))) {
				tail--;
			}
			// Need to break is tail reach the head of string
            if (tail < 0) {
                break;
            }
            
			head = tail;
			while (head >= 0 && !Character.isSpace(s.charAt(head))) {
				sb1.append(s.charAt(head--));
			}
			sb.append(sb1.reverse().toString());
			sb.append(" ");
            tail = head;
		}

		if (sb.length() < 2) {
			return "";
		} else {
			return sb.deleteCharAt(sb.length() - 1).toString();
		}
	}
}