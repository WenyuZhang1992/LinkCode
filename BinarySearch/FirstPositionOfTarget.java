/**
     * Description:
     * For a given sorted array (ascending order) and a target number, 
     * find the first index of this number in O(log n) time complexity.
     * If the target number does not exist in the array, return -1.
     *
     * Example:
     * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
     * 
     * Analysis: sorted array and target number are symbols for binary search 
     *           with complexity of O(logn)
     *
     * Notice: 1. Special cases when array is null or length is 0;
     *         2. Loop condition (start+1 < end), stops when start is next to end;
     *         3. Assign middle: middle = start + (end - start)/2, avoid overflow;
     *         4. Compare cases: ==, <, >;
     */

class FirstPositionOfTarget {

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (end - start > 1) {
            mid = start + (end - start)/2;
            if (nums[mid] >= target) {
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

    public static void main(String[] argv) {
        int[] arr = {1, 2, 3, 3, 4, 5, 10};
        System.out.println(binarySearch1(arr, 3));
    }
}