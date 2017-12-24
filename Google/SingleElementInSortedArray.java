/**
 *  540. Single Element in a Sorted Array
 *  https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 */

class SingleElementInSortedArray {

    /**
     * Version 1: Use Binary Search
     *            The paired elements occurs before single elements have first occurrence at even position;
     *            The paired elements occurs after single elements have first occurrence at odd position;
     *      Time: O(logn)
     *     Space: O(1)
     */
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length % 2 == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 0) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (end - start > 2) {
            mid = start + (end - start) / 2;

            if (nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid]) {
                return nums[mid];
            }
            // If mid is a odd number
            if (mid % 2 == 1) {
                // odd position is the starting
                if (nums[mid - 1] == nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                // If mid is a even number
                if (nums[mid - 1] == nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        if (nums[start] == nums[start + 1]) {
            return nums[end];
        } else {
            return nums[start];
        }
    }
}

