/**
 *	26. Remove Duplicates from Sorted Array
 *	https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
class RemoveDuplicatesFromSortedArray {

	/**
	 * Version 1: Use Two Pointers
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length < 2) {
			return nums.length;
		}

		int start = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[start]) {
				nums[++start] = nums[i];
			}
		}

		return start + 1;
	}
}