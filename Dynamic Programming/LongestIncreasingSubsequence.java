/**
 *	300. Longest Increasing Subsequence
 *	https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
class LongestIncreasingSubsequence {
	
	/**
	 * Version 1: Use DP
	 *      Time: O(n^2)
	 *     Space: O(n)
	 */
	public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Subproblem: LIS length ending at position i
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        
        for (int i=1; i<nums.length; i++) {
            dp[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}