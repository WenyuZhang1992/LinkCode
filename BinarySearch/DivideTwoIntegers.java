import java.util.*;

/**
 * Divide Two Integers
 *
 * Description:
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return 2147483647
 *
 * Analysis: Can use bitwise operstion to solve this problem
 */
public class DivideTwoIntegers {

    /**
     * Version 1: Use bitwise operstion to solve this problem
     *      Time: 
     *     Space: O(1)
     */
    public static int divide(int dividend, int divisor) {
    	// special cases
    	if (divisor == 0) {
    		return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    	}
    	if (dividend == 0) {
    		return 0;
    	}
    	if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

    	boolean sign = ((dividend > 0) && (divisor > 0)) || ((dividend < 0) && (divisor < 0));
    	int result = 0;

    	long a = Math.abs((long)dividend);
    	long b = Math.abs((long)divisor);

    	while (a >= b) {
    		int shift = 0;

    		while (a >= (b << shift)) {
    			++shift;
    		}
    		result += 1 << (shift - 1);
    		a -= b << (shift - 1);
    	}
    	return sign ? result : (-result);
    }

    public static void main(String[] argv) {
    	System.out.println("Result of (2, 2): " + divide(2, 2));
    }
}