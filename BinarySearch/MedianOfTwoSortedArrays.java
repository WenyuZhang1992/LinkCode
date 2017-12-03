/**
 *	4. Median of Two Sorted Arrays
 *	https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
class MedianOfTwoSortedArrays {

	/**
	 * Version 1: Use Binary Search and transform the problem into find the Kth element of two sorted arrays
	 *      Time: O(log(m + n))
	 *     Space: 
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            return (findKth(nums1, nums2, 0, 0, totalLength / 2 + 1) + findKth(nums1, nums2, 0, 0, totalLength / 2 )) / 2.0;
        } else {
            return findKth(nums1, nums2, 0, 0, totalLength / 2 + 1);
        }
    }

    // Find kth element of two sorted arrays
    private int findKth(int[] nums1, int[] nums2, int start1, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int mIndex1 = start1 + k / 2 - 1;
        int mIndex2 = start2 + k / 2 - 1;

        int midValue1 = mIndex1 < nums1.length ? nums1[mIndex1] : Integer.MAX_VALUE;
        int midValue2 = mIndex2 < nums2.length ? nums2[mIndex2] : Integer.MAX_VALUE;

        if (midValue1 < midValue2) {
            return findKth(nums1, nums2, mIndex1 + 1, start2, k - k / 2);
        } else {
            return findKth(nums1, nums2, start1, mIndex2 + 1, k - k / 2);
        }
    } 
}