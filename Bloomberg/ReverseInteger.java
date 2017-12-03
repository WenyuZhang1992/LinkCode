/**
 *	7. Reverse Integer
 *	https://leetcode.com/problems/reverse-integer/description/
 */
class ReverseInteger {

	/**
	 * Version 1: Use long-type variable to track the reversed value
	 *            Take care of cases: Integer.MIN_VALUE and result > Integer.MAX_VALUE
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public int reverse(int x) {
		boolean flag = false;
		if (x >= 0) {
			flag = true;
		} 

		long positiveCopy = Math.abs(x);
		long result = 0;

		while (positiveCopy > 0) {
			result = result * 10 + positiveCopy % 10;
			positiveCopy /= 10;
		}

		if (result == Integer.MAX_VALUE + 1 && flag == false) {
			return (int) (-result);
		}
		if (result > Integer.MAX_VALUE) {
			return 0;
		}

		return flag == true ? (int) result : (int) (-result);
	}
}