/**
 *	231. Power of Two
 *	https://leetcode.com/problems/power-of-two/description/
 */
class PowerOfTwo {

	/**
	 * Version 1: Use BitManipulation: Integer that is power of two has all 0 bits except the most important bit;
     *            For example: 8 -> 1000, 4 -> 100, 2 -> 10
     *            So we only need to check if any bit contains 1 and the most important bit must be 1
     *            Use module can achieve this goal;
	 *      Time: O(logn) -> length of the binary representation of an integer
	 *     Space: O(1)
	 */
	public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if (n % 2 == 1) {
                return false;
            }
            n /= 2;
        }
        
        return false;
    }

    /**
     * Version 2: If n is power of two, so it has only single 1 in most important bit thus (n-1) are all 1s
     *            For example, 8 -> 1000, 7 -> 111
     *            Therefore, (n & (n-1)) == 0
     *      Time: O(logn) -> we still need to do bit-wise comparision
     *     Space: O(1)
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}