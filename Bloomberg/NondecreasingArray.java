/**
 *	665. Non-decreasing Array
 *	https://leetcode.com/problems/non-decreasing-array/description/
 */
class NondecreasingArray {

	/**
	 * Version 1: Use a flag to indicate whether modification already made
	 *			  Need to compre continuous 3 elements:
	 *			  If there's no first element -> modify the second to smaller value
	 *			  If third element is larger than the first -> modify the second to smaller value
	 *			  If third element is smaller than the first -> modify the third element to larger value
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        
        boolean used = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (used) { return false; }
                if (i == 1) {
                    nums[i - 1] = nums[i];
                } else if (nums[i] > nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
                used = true;
            }
        }
        return true;
    }
}