/**
 *	342. Power of Four
 *	https://leetcode.com/problems/power-of-four/description/
 */
class PowerOfFour {

	/**
	 * Version 1: Use BitManipulation: Integer that is power of four has all 0 bits except the most important bit;
     *            And the most important bit is at even position;
     *            For example: 16 -> 100000(1 is at 4th bit), 4 -> 100(1 is at 2th bit)
	 *      Time: O(logn) -> length of the binary representation of an integer
	 *     Space: O(1)
	 */
	public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        
        int bitCount = 0;
        while (num > 1) {
            if (num % 2 == 1) {
                return false;
            }
            num = num / 2;
            ++bitCount;
        }
        if (bitCount % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}