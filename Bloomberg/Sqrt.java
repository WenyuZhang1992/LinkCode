/**
 *	69. Sqrt(x)
 *	https://leetcode.com/problems/sqrtx/description/
 */
class Sqrt {

	/**
	 * Version 1: Use Binary Search, need long type to handle the value of mid * mid otherwise overflow
	 *      Time: O(logn)
	 *     Space: O(1)
	 */
	public int mySqrt(int x) {
        if (x < 0) {
        	return Integer.MIN_VALUE;
        }
        if (x == 0 || x == 1) {
            return x;
        }
        
        int start = 0;
        int end = x / 2 + 1;
        int mid;

        while (end - start > 1) {
        	mid = start + (end - start) / 2;
            long temp = (long) mid * mid;
        	if (temp == x) {
        		return mid;
        	} else if (temp < x) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }

        return start;
    }
}