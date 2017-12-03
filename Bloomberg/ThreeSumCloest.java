/**
 *	16. 3Sum Closest
 *	https://leetcode.com/problems/3sum-closest/description/
 */
class ThreeSumCloest {

	/**
	 * Version 1: Use two pointers, degrade 3Sum to 2Sum
	 *      Time: O(n^2)
	 *     Space: O(1)
	 */
	public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
        	return Integer.MIN_VALUE;
        }

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
        	int start = i + 1;
        	int end = nums.length - 1;
        	while (start < end) {
        		int sum = nums[i] + nums[start] + nums[end];
        		if (Math.abs(sum - target) < Math.abs(result - target)) {
        			result = sum;
        		} else if (sum > target) {
        			end--;
        		} else {
        			start++;
        		}
        	}
        }

        return result;
    }
}