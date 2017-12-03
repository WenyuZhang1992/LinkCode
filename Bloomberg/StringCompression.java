/**
 *	443. String Compression
 *	https://leetcode.com/problems/string-compression/description/
 */
class StringCompression {

	/**
	 * Version 1: Use Two Pointers
	 *			  Note: notice to add the last character!
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int tail = 0;
        int start = 0;
        int end = 1;
        
        while (start < chars.length && end < chars.length) {
            if (chars[start] == chars[end]) {
                ++end;
            } else {
                int length = end - start;
                chars[tail++] = chars[start];
                if (length > 1) {
                    String temp = String.valueOf(length);
                    for (int i = 0; i < temp.length(); i++) {
                        chars[tail++] = temp.charAt(i);
                    }
                }
                start = end++;
            }
        }
        
        // Adding last character
        int length = end - start;
        chars[tail++] = chars[start];
        if (length > 1) {
            String temp = String.valueOf(length);
            for (int i = 0; i < temp.length(); i++) {
                chars[tail++] = temp.charAt(i);
            }
        }
        
        return tail;
    }
}