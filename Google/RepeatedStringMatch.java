/**
 *	686. Repeated String Match
 *	https://leetcode.com/problems/repeated-string-match/description/
 */
class RepeatedStringMatch {

	/**
	 * Version 1: 
	 *      Time: O(N*(M + N)) -> we create a string at most of length O(M + N)
     *                            then traverse the string to find a match
	 *     Space: O(M + N) -> we create a string at most of length O(M + N)
	 */
	public int repeatedStringMatch(String A, String B) {
        if (A == null || B == null) {
            return -1;
        }

        int n = B.length();
        String repeat = A;
        int count = 1;
        while (repeat.length() < n) {
            repeat += A;
            ++count;
        }

        if (repeat.indexOf(B) != -1) {
            return count;
        }

        // corner case: abc => cab
        repeat += A;
        return repeat.indexOf(B) != -1 ? count + 1 : -1;
    }
}