/**
 *	283. Move Zeroes
 *	https://leetcode.com/problems/move-zeroes/description/
 */
class MoveZeroes {

	/**
	 * Version 1: Use two pointers
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int start = 0;
        int end = 0;
        
        while (end < nums.length) {
            if (nums[end] == 0) {
                end++;
            } else {
                nums[start] = nums[end];
                start++;
                end++;
            }
        }
        
        while (start < nums.length) {
            nums[start] = 0;
            start++;
        }
    }
}