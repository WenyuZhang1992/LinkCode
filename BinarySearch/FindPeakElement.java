import java.util.*;

/** Description:
 *  There is an integer array which has the following features:
 *  1.The numbers in adjacent positions are different.
 *  2.A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 *  We define a position P is a peek if:
 *  A[P] > A[P-1] && A[P] > A[P+1]
 *  Find a peak element in this array. Return the index of the peak.
 */
class FindPeakElement {
    /**
     * Version 1: Use Binary Search, compare the mid with its adjacents
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
