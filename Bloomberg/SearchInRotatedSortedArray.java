/**
 *	33. Search in Rotated Sorted Array
 *	https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
class SearchInRotatedSortedArray {

	/**
	 * Version 1: Use Binary Search
	 *      Time: O(logn)
	 *     Space: O(1)
	 */
	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (end - start > 1) {
            mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            // First half is sorted
            if (nums[mid] > nums[start]) {
                if (nums[mid] >= target && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else { 
                // Second half is sorted
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}