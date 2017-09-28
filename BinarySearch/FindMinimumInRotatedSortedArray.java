import java.util.*;

public class FindMinimumInRotatedSortedArray {

    /**
 	 * Find Minimum in Rotated Sorted Array
 	 *
 	 * Description:
 	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 	 * Find the minimum element.
 	 *
 	 * Notice: You may assume no duplicate exists in the array.
  	 *
  	 * Analysis: Use Binary Search, find the rotated position.
  	 *           Notice the array could be unrotated or all elements are the same
 	 */
    public int findMin(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return Integer.MAX_VALUE;

    	// When the array is not rotated
    	if (nums[0] <= nums[nums.length - 1])
    		return nums[0];

    	int start = 0;
    	int end = nums.length - 1;
    	int mid;
    	while (end - start > 1) {
    		mid = start + (end - start)/2;
    		if (nums[mid] >= nums[start]) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}

    	return Math.min(nums[start], nums[end]);
    }

    /**
 	 * Find Minimum in Rotated Sorted Array II
 	 *
 	 * Description:
 	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * Find the minimum element.
	 * 
	 * Notice: The array may contain duplicates.
  	 *
 	 */

    /**
     * Version 1: Use Divide and Conquer
     *      Time: O(nlogn)
     *     Space: O(1)
     */
    public static int findMinDC(int[] num) {
    	if (num == null || num.length == 0)
    		return Integer.MAX_VALUE;

    	return findMinRecr(num, 0, num.length - 1);
    }

    private static int findMinRecr(int[] nums, int start, int end) {
    	if (start > end) {
    		return Integer.MAX_VALUE;
    	}
    	if (start == end) {
    		return nums[start];
    	}

    	int mid = start + (end - start)/2;
    	return Math.min(findMinRecr(nums, start, mid), findMinRecr(nums, mid+1, end));
    }

    /**
     * Version 2: Use Binary Search, check if num[start]==num[end], move start pointer right till not equal
     *      Time: O(logn)
     *Worst Case: O(n) -> all elements are same
     *     Space: O(1)
     */
    public static int findMinBS(int[] num) {
    	if (num == null || num.length == 0)
    		return Integer.MAX_VALUE;

    		
    	int start = 0;
    	int end = num.length - 1;
    	int mid;
    	while (end - start > 1) {
    		while (num[start] == num[end] && start != end) {
    			start++;
    		}
    		
    		// When the array is not rotated
    	    if (num[start] <= num[end])
    		    return num[start];
    		
    		mid = start + (end - start)/2;
    		if (num[mid] >= num[start]) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}

    	return Math.min(num[start], num[end]);
    }

    public static void main(String[] argv) {
    	int[] nums = {4, 5, 6, 7, 0, 1, 2};
    	System.out.println(findMinBS(nums));

    }
}