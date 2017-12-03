/**
 *	13. Roman to Integer
 *	https://leetcode.com/problems/roman-to-integer/description/
 */
class RomantoInteger {
	
	/**
	 * Version 1: Try to combine currect character with next one
     *            if curr >= next, sum += current and move to next
     *            if curr <  next, sum += next - curr
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int index = 0;
        int curr = 0;
        int sum = 0;

        while (index < s.length()) {
            curr = map.get(s.charAt(index));
            int next = 0;
            if (index + 1 < s.length()) {
                next = map.get(s.charAt(index + 1));
            }
            if (curr < next) {
                sum += next - curr;
                index = index + 2;
            } else {
                sum  += curr;
                index++;
            }
        }

        return sum;
    }
}