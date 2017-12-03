/**
 *	189. Rotate Array
 *	https://leetcode.com/problems/rotate-array/description/
 */
class RotateArray {

	/**
	 * Version 1: Reverse the array, then reverse 0 to (k-1) and k to end separately
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
        	return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
    	if (start >= end) {
    		return;
    	}
    	while (start < end) {
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start++;
    		end--;
    	}
    }
}