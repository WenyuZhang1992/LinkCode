/**
 *	43. Multiply Strings
 *	https://leetcode.com/problems/multiply-strings/description/
 */
class MultiplyStrings {
	
	/**
	 * Version 1: Use DFS to get all subsets starting at certain index
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] digits = new int[num1.length() + num2.length() - 1];

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                digits[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int index = digits.length - 1; index >= 0; index--) {
            int digit = (digits[index] + carry) % 10;
            carry = (digits[index] + carry) / 10;
            sb.append(digit);
        }
        
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}