/**
 *	268. Missing Number
 *	https://leetcode.com/problems/missing-number/description/
 */
class MissingNumber {

	/**
	 * Version 1: Calculate the sum of [0,..., n]
	 *            Substract the sum of the array
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int sum = nums.length * (nums.length + 1) / 2;
        int total = 0;
        
        for (int num : nums) {
            total += num;
        }
        
        return sum - total;
    }
}