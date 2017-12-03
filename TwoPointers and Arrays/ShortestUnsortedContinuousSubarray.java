/**
 *	581. Shortest Unsorted Continuous Subarray
 *	https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 */
class ShortestUnsortedContinuousSubarray {
	
	/**
	 * Version 1: Sort the array
     *            Find out the first position and last position whose value is different from original array
	 *      Time: O(nlogn)
	 *     Space: O(n)
	 */
	public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Need a copy of the original array
        int[] unsorted = nums.clone();
        Arrays.sort(nums);
        int start = -1;
        int end = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            if (unsorted[i] != nums[i]) {
                start = i;
                break;
            }
        }
        
        for (int j = nums.length - 1; j >= 0; j--) {
            if (unsorted[j] != nums[j]) {
                end = j;
                break;
            }
        }
        
        // Original array might be ascending already
        if (start == -1 && end == nums.length) {
            return 0;
        }
        
        return end - start + 1;
    }

    /**
     * Version 2: Use a stack
     *      Time: O(n)
     *     Space: O(n)
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int left = nums.length;
        int right = -1;

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }

        return right - left > 0 ? right - left + 1 : 0; 
    }

    /**
     * Version 3: Find out the minValue and maxValue of the unsorted portion
     *            Then find their correct position as in ascending array
     *      Time: O(n)
     *     Space: O(1)
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                min = Math.min(min, nums[i]);
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
            }
        }
        
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l]) { break; }
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r]) { break; }
        }
        
        return r - l < 0 ? 0 : r - l + 1;
    }
}