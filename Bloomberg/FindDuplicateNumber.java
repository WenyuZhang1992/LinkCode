/**
 *	287. Find the Duplicate Number
 *	https://leetcode.com/problems/find-the-duplicate-number/description/
 */
class FindDuplicateNumber {

	/**
	 * Version 1: Use Binary Search, count the elements smaller than mid
	 *      Time: O(nlogn)
	 *     Space: O(1)
	 */
	public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
        	return Integer.MIN_VALUE;
        }

        int start = 1;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
        	mid = start + (end - start) / 2;

        	// Count number of elements smaller than or equal to mid
        	int count = 0;
        	for (int num : nums) {
        		if (num <= mid) {
        			count++;
        		}
        	}

        	if (count > mid) {
        		end = mid - 1;
        	} else {
        		start = mid + 1;
        	}
        }

        return start;
    }
}