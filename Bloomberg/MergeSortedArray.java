/**
 *	88. Merge Sorted Array
 *	https://leetcode.com/problems/merge-sorted-array/description/
 */
class MergeSortedArray {

	/**
	 * Version 1: Use two pointers
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n <= 0) {
            return;
        }

        int tail = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[tail--] = nums2[p2--]; 
            } else {
                nums1[tail--] = nums1[p1--];
            }
        }

        while (p2 >= 0) {
            nums1[tail--] = nums2[p2--];
        }
    }
}