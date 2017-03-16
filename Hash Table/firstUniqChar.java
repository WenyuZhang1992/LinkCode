import java.util.*;

public class Solution {
    /* Leetcode 387: First Unique Character in a String
     *     Analysis: Traverse through the string once and store 
     *               <char, times> in LinkedHashMap
     *               Need LinkedHashMap cause need to maintain the order
     *         Time: O(n) cause only traverse once string and HashMap size is limit to characters
     *        Space: O(1) Map.size() -> 26 lower-case letters
     */
	public static void main(String args[] ) {
        System.out.println(firstNonDuplicate("GeeksforGeeks"));
    }
    
    // Using LinkedHashMap
    private static char firstNonDuplicate(String str) {
        if (str == null || str.length() == 0)
        	return ' ';
        
        int i;
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (i=0; i<str.length(); i++) {
        	if (map.get(str.charAt(i)) != null) {
        		map.put(str.charAt(i), map.get(str.charAt(i))+1);
        	}
        	else
        		map.put(str.charAt(i), 1);
        }
        Set<Character> keys = map.keySet();
        for (char key : keys) {
        	if (map.get(key) == 1)
        		return key;
        }
        return ' ';
    }

    // Using Two-dimensional array
    private static int firstUniqChar(String s) {
        // Special cases
        if (s == null || s.length() == 0)
            return -1;
        
        // Create array to store characters
        // including occurring times and index
        int[][] chars = new int[26][2];
        for (int i=0; i<s.length(); i++) {
            // Last index
            chars[(int)(s.charAt(i)-'a')][0] = i;
            // Times
            chars[(int)(s.charAt(i)-'a')][1]++;
        }
        
        int min = s.length();
        for (int j=0; j<chars.length; j++) {
            if (chars[j][1] == 1)
                min = Math.min(min, chars[j][0]);
        }
        return min==s.length()?-1:min;
    }

}