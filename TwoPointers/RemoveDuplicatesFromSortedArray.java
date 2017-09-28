import java.util.*;

/**
 * Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 */

class RemoveDuplicatesFromSortedArray {
	
	/**
	 * Version 1: Use two pointers
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int start = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[start] != nums[i]) {
				nums[++start] = nums[i];
			}
		}

		return start + 1;
	}

	/**
	 * Remove Duplicates from Sorted Array II
	 * Follow up for "Remove Duplicates":
     * What if duplicates are allowed at most twice?
     * 1,1,1,2,2,3 -> 1,1,2,2,3 
     *
     * Version 1: 
     *      Time:
     *     Space:
     */
	public int removeDuplicatesII(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length <= 2) {
			return nums.length;
		}

		int tail = 0;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[tail] != nums[i]) {
				nums[++tail] = nums[i];
				count = 1;
			} else if (count < 2) {
				count++;
				nums[++tail] = nums[i];
			}
		} 

		return tail + 1;
	}
}