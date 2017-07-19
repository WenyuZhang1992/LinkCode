package BinarySearch;

import java.util.*;

/**
 * Classical Binary Search
 * Find any position of a target number in a sorted array. Return -1 if target does not exist.
 */
public class ClassicalBinarySearch {

	/**
     * Version 1: Use Binary Search
     *      Time: O(logn)
     *     Space: O(1)
     */
	public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0)
        	return -1;

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (end - start > 1) {
        	mid = start + (end - start)/2;
        	if (nums[mid] == target) {
        		return mid;
        	} else if (nums[mid] > target) {
        		end = mid;
        	} else {
        		start = mid;
        	}
        }

        if (nums[start] == target)
        	return start;
        if (nums[end] == target)
        	return end;

        return -1;
    }
}