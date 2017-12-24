/**
 *	524. Longest Word in Dictionary through Deleting
 *	https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 */
class LongestWordInDictionaryThroughDeleting {

	/**
	 * Version 1: Sort the dictionary
     *            Traverse from largest order to smallest order to find match
     *            Find the matching word with longest length
	 *      Time: O(n*k*logn) -> n is the size of the dictionary, k is the average word size
	 *     Space: O(logn) -> sorting needs O(logn) space
	 */
	public String findLongestWord(String s, List<String> d) {
        Collections.sort(d);

        int length = Integer.MIN_VALUE;
        int index = -1;
        for (int i = d.size() - 1; i >= 0; --i) {
            String str = d.get(i);
            int p1 = 0;
            int p2 = 0;
            while (p1 < s.length() && p2 < str.length()) {
                if (s.charAt(p1) == str.charAt(p2)) {
                    ++p1;
                    ++p2;
                } else {
                    ++p1;
                }
            }

            // Found a match
            if (p2 == str.length() && str.length() >= length) {
                length = str.length();
                index = i;
                continue;
            }
        }

        if (index != -1) {
            return d.get(index);
        }
        return "";
    }

    /**
     * Version 2: Directly traverse the dictionary
     *            Check if the word can be constructed by deleting, compare the length and lexicographical order
     *      Time: O(n*k) -> n is the size of the dictionary, k is the average word size
     *     Space: O(1)
     */
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String word : d) {
            if (helper(s, word) && word.length() > result.length()) {
                result = word;
            } else if (helper(s, word) && word.length() == result.length() && word.compareTo(result) < 0) {
                result = word;
            }
        }

        return result;
    }

    private boolean helper(String s, String word) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < s.length() && p2 < word.length()) {
            if (s.charAt(p1) == word.charAt(p2)) {
                ++p1;
                ++p2;
            } else {
                ++p1;
            }
        }

        if (p2 == word.length()) {
            return true;
        } else {
            return false;
        }
    }
}