import java.util.*;

/**
 * Find the Duplicate Number
 *
 * Description:
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. 
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Notice:
 * 1. You must not modify the array (assume the array is read only).
 * 2. You must use only constant, O(1) extra space.
 * 3. Your runtime complexity should be less than O(n^2).
 * 4. There is only one duplicate number in the array, but it could be repeated more than once
 *
 */
public class FindDuplicateNumber {

	/**
     * Version 1: Use Binary Search, take mid and count the number of elements smaller than mid
     *      Time: O(nlogn)
     *     Space: O(1)
     */
	public static int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
        	return -1;

        int start = 1;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
        	mid = start + (end - start)/2;

        	int count = 0;
        	for (int i=0; i < nums.length; i++) {
        		if (nums[i] <= mid)
        			count++;
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