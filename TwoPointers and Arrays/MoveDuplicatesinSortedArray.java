/**
 *	Move duplicates in sorted array to front of the array and return the number of distinct elements
 *  Example: [1,1,2,2,3,4,4,5,5,5]
 *           [1,2,3,4,5,...] and return 5
 */
class MoveDuplicatesinSortedArray {

    public int moveDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length < 2) {
            return nums.length;
        }

        int start = 1;
        int end = 1;
        int prev = nums[0];
        
        while (end < nums.length) {
            if (nums[end] != prev) {
                nums[start] = nums[end++];
                prev = nums[start++];
            } else {
                end++;
            }
        }

        return start;
    }
}