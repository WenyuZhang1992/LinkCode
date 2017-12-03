/**
 *	50. Pow(x, n)
 *	https://leetcode.com/problems/powx-n/description/
 */
class Pow {
	
	/**
	 * Version 1: Use divide-conquer, need to consider the situation when n < 0;
     *            x^n = x^(n/2) * x^(n/2) * x(n%2)
	 *      Time: O(logn) -> O(1) to break n to two n/2 and totally O(logn) levels
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
            return 1;
        }
        
        if (n == 1) {
            return x;
        }
        
        double result = positivePow(x, n/2);
        result *= result;
        if (n % 2 != 0) {
            result *= x;
        }
        return result;
    }
}