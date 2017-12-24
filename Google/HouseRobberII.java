/**
 *	213. House Robber II
 *	https://leetcode.com/problems/house-robber-ii/description/
 */
class HouseRobberII {

	/**
	 * Version 1: Use DP
     *            Consider two conditions: 1. Take the first but skip the last;
     *                                     2. Skip the first but take the last;
     *            Calculate the results of these two conditions and return the largest value;
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    private int robHelper(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }

        int[] dp = new int[nums.length];
        dp[i] = nums[i];
        dp[i + 1] = Math.max(dp[i], nums[i + 1]);
        for (int k = i + 2; k <= j; ++k) {
            dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k]);
        }
        return dp[j];
    }
}