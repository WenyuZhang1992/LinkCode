/**
 *	209. Minimum Size Subarray Sum
 *	https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
class MinimumSizeSubarraySum {
	
	/**
	 * Version 1: Use Two Pointers to traverse the array
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s && start <= end) {
                length = Math.min(length, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        
        return length == Integer.MAX_VALUE ? 0 : length;
    }

    /**
     * Version 1: Use binary search
     *            Construct a sums array, the element i represent the sum from 0 to i - 1 of nums array
     *            Then, use binary search to find a minimum position in sums array that sums[j] >= sums[i] + s
     *      Time: O(nlogn)
     *     Space: O(1)
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        
        for (int i = 1; i < sums.length; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int j = binarySearch(sums, i, sums[i] + s);
            if (j > i) {
                length = Math.min(length, j - i);
            }
        }
        
        return length == Integer.MAX_VALUE ? 0 : length;
    }
    
    private int binarySearch(int[] sums, int index, int target) {
        if (index >= sums.length - 1) {
            return -1;
        }
        
        int start = index + 1;
        int end = sums.length - 1;
        int mid;
        
        while (end - start > 1) {
            mid = start + (end - start) / 2;
            if (sums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (sums[start] >= target) {
            return start;
        } else if (sums[end] >= target) {
            return end;
        } else {
            return -1;
        }
    }
}