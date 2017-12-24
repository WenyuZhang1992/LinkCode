/**
 *	318. Maximum Product of Word Lengths
 *	https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 */
class MaximumProductOfWordLengths {

	/**
	 * Version 1: Use a 2D array to indicate whether two words share common characters or not
     *            Traverse the 2D array and update the maximum product
	 *      Time: O(n^2 * k) -> n is the length of words[] array, k is the average length of strings
	 *     Space: O(n^2) -> n is the length of the words[] array
	 */
	public int maxProduct(String[] words) {
        int length = words.length;
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (!common(words[i], words[j])) {
                    dp[i][j] = true;
                }
            }
        }

        int product = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (dp[i][j]) {
                    product = Math.max(words[i].length() * words[j].length(), product);
                }
            }
        }

        return product;
    }

    private boolean common(String s1, String s2) {
        boolean[] chars = new boolean[26];
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            chars[index] = true;
        }

        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 'a';
            if (chars[index]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Version 2: Use Bit Operation, use lower 26 bits of an integer to represent the character usage of a string
     *      Time: O(n*k + n^2) -> n is the length of the words[], k is the average length of string
     *     Space: O(n)
     */
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] bits = new int[length];

        for (int i = 0; i < length; i++) {
            int value = 0;
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                value |= 1 << (c - 'a');
            }
            bits[i] = value;
        }

        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    maxLength = Math.max(maxLength, words[i].length() * words[j].length());
                }
            }
        }

        return maxLength;
    }
}