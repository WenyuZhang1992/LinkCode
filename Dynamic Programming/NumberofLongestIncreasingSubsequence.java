/**
 *	673. Number of Longest Increasing Subsequence
 *	https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 */
class NumberofLongestIncreasingSubsequence {
	
	/**
	 * Version 1: Use DP, first use DP to get LIS length, then use DP to get LIS number
	 *      Time: O(n^2)
	 *     Space: O(n)
	 */
	public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // LIS length ending at position i
        int[] dp = new int[nums.length];
        // Number of LIS end at p[osition i
        int[] ans = new int[nums.length];
        
        dp[0] = 1;
        ans[0] = 1;
        int max = 1;
        
        for (int i=1; i<nums.length; i++) {
            dp[i] = 1;
            ans[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    ans[i] = ans[j];
                } else if (nums[j] < nums[i] && dp[j] + 1 == dp[i]){
                    // dp[i] not change
                    ans[i] += ans[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        int result = 0;
        for (int m=0; m < ans.length; m++) {
            if (dp[m] == max) {
                result += ans[m];
            }
        }
        
        return result;
    }
}