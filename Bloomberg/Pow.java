/**
 *	50. Pow(x, n)
 *	https://leetcode.com/problems/powx-n/description/
 */
class Pow {

	/**
	 * Version 1: Use recursion
	 *      Time: O(logn)
	 *     Space: O(1)
	 */
	public double myPow(double x, int n) {
		if (n >= 0) {
			return positivePow(x, n);
		} else {
			return 1 / positivePow(x, -n);
		}
	}

	private double positivePow(double x, int n) {
		if (n == 0) {
			return (double) 1;
		}
		if (n == 1) {
			return x;
		}

		double result = positivePow(x, n / 2);
		result *= result;

		// Have to check with 0
		// can't check with 1
		if (n % 2 != 0) {
			result *= x;
		}
		return result;
	}
}