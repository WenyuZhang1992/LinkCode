/**
 *	242. Valid Anagram
 *	https://leetcode.com/problems/valid-anagram/description/
 */
class ValidAnagram {
	
	/**
	 * Version 1: Use sort and HashCode
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return true;
        }
        return getHashCode(s) == getHashCode(t);
    }
    
    private int getHashCode(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.hashCode(chars);
    }

    /**
     * Version 2: Use HashTable
     *      Time: O(n)
     *     Space: O(1)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        for (int i=0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a'] = counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a'] = counts[t.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}