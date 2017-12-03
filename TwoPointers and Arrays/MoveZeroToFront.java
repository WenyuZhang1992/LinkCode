/**
 *	Given an array, move all zeroes in the array to front of the array and return the number of zeroes in the array.
 */
class MoveZeroToFront {

    /**
     * Version 1: Use two pointers, one record the first non-zero position to be replaced, 
     *            the other traversal the array
     *      Time: O(n)
     *     Space: O(1)
     */
	public int moveZeroToFront(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = 0;

        while (start < (nums.length - 1) && end < nums.length) {
            if (nums[start] == 0) {
                start++;
                end = start + 1;
                continue;
            }

            if (nums[end] == 0) {
                int temp  = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end++;
                start++;
            } else {
                end++;
            }
        }

        // Possible all zeroes array
        return nums[start] == 0 ? start + 1 : start;
    }
}