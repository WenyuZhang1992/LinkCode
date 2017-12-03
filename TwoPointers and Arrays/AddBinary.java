import java.util.*;

/**
 * Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 */
class AddBinary {
	
	/**
     * Version 1: Use two pointers
     *      Time: O(m + n)
     *     Space: O(1)
     */
	public String addBinary(String a, String b) {
        if (a == null) {
        	return b;
        }
        if (b == null) {
        	return a;
        }

        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carry = 0;
        String result = "";

        while (pa >= 0 && pb >= 0) {
        	int sum = (a.charAt(pa) - '0') + (b.charAt(pb) - '0') + carry;
        	result = sum % 2 + result;
        	carry = sum / 2; 
        	pa--;
        	pb--;
        }

        while (pa >= 0) {
        	int sum = (a.charAt(pa) - '0') + carry;
        	result = sum % 2 + result;
        	carry = sum / 2; 
        	pa--;
        }

        while (pb >= 0) {
        	int sum = (b.charAt(pb) - '0') + carry;
        	result = sum % 2 + result;
        	carry = sum / 2; 
        	pb--;
        }

        return carry == 0 ? result : carry + result;
    }
}