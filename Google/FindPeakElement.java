/**
 *	162. Find Peak Element
 *	https://leetcode.com/problems/find-peak-element/description/
 */
class FindPeakElement {

	/**
	 * Version 1: Use Binary Search
     *            Since adjacent elements are not equal, and nums[-1] = nums[n] = Integer.MIN_VALUE,
     *            there must be a peek element;
     *
     *            Every in the mid position, move the pointers to the increasing side since can't be always increasing(bounds are minimum) 
	 *      Time: O(logn)
	 *     Space: O(1)
	 */
	public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return 0;
        }
        
        int start = 0;
        int mid;
        int end = nums.length - 1;
        
        while (end - start > 1) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return nums[start] > nums[end] ? start : end;
    }
}