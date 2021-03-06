/**
 *	76. Minimum Window Substring
 *	https://leetcode.com/problems/minimum-window-substring/description/
 */
class MinimumWindowSubstring {
	
	/**
	 * Version 1: Use Two Pointers and HashTable to record how many characters matched
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        
        // Construct target map for comparison
        HashMap<Character, Integer> target = new HashMap();
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if (target.containsKey(c)) {
                target.put(c, target.get(c) + 1);
            } else {
                target.put(c, 1);
            }
        }
        
        String result = "";
        int minLength = s.length() + 1;
        int count = 0;
        int left = 0;
        
        // Record target characters in source string
        HashMap<Character, Integer> map = new HashMap();
        
        for (int i=0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (target.containsKey(curr)) {
                if (map.containsKey(curr)) {
                    if (map.get(curr) < target.get(curr)) {
                        count++;
                    }
                    map.put(curr, map.get(curr) + 1);
                } else {
                    map.put(curr, 1);
                    count++;
                }
            }
            
            if (count == t.length()) {
                char sc = s.charAt(left);
                while (!target.containsKey(sc) || map.get(sc) > target.get(sc)) {
                    if (target.containsKey(sc) && map.get(sc) > target.get(sc)) {
                        map.put(sc, map.get(sc) - 1);
                    }
                    left++;
                    sc = s.charAt(left);
                }
                
                if (i - left + 1 < minLength) {
                    result = s.substring(left, i + 1);
                    minLength = i - left + 1;
                }
            }
        }
        
        return result;
    }
}