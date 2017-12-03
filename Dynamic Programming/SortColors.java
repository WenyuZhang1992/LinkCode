/**
 *	75. Sort Colors
 *	https://leetcode.com/problems/sort-colors/description/
 */
class SortColors {
	
	/**
	 * Version 1: Use two pointers
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        int i = 0;
        
        // 0 0 0 1 1 1 curr curr+1 ... curr+n 2 2 2
        //       s       i                e
        // swap with start indexed, no need to check cause nums[start] must be 1
        // swap with end indexed, need to check again
        while (i < end + 1) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                start++;
                i++;
            } else {
                int temp = nums[end];
                nums[end] = nums[i];
                nums[i] = temp;
                end--;
            }
        }
    }
}