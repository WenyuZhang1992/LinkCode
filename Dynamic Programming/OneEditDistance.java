/**
 *	161. One Edit Distance
 *	Given two strings S and T, determine if they are both one edit distance apart.
 */
class OneEditDistance {

	/**
	 * Version 1: Calculate string length difference;
	 *		      If diff == 0, need to replace one character -> when encounter different characters directly increment both pointers;
	 *			  If diff == 1, need to insert one character -> when encounter different characters only increment both longer string's pointer;
	 *			  Need to take care of the situation to insert one character at the end of string t;
	 *      Time: O(n) -> traverse two strings once
	 *     Space: O(1)
	 */
    public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) {
            return false;
        }

        // Make sure s.length() >= t.length()
        if (t.length() > s.length()) {
            return isOneEditDistance(t, s);
        }

        int diff = s.length() - t.length();
        boolean flag = false;

        int p1 = 0;
        int p2 = 0;

        while (p1 < s.length() && p2 < t.length()) {
            if (s.charAt(p1) != t.charAt(p2) && !flag) {
                flag = true;
                if (diff == 1) {
                    p1++;
                    continue;
                }
            } else if (s.charAt(p1) != t.charAt(p2)) {
                return false;
            }
            p1++;
            p2++;
        }

        // Take care of the situation to insert one character at the end of string t
        if (!flag && diff == 1 && p1 == p2 && p2 == t.length()) {
            flag = true;
        }
        return flag;
    }
}