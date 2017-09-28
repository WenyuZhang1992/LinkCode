/**
  * Leetcode 300: Longest Increasing Subsequence
  * https://leetcode.com/problems/longest-increasing-subsequence/description/
  */
import java.util.*;

class LongestIncreasingSubsequence {

	/**
	 * Version 1: Use DP with an array to store max_length of current element
	 *      Time: O(n^2)
	 *     Space: O(n)
	 */
	public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] result = new int[nums.length];
        result[0] = 1;
        
        int maxLength = 1;
        for (int i=1; i<result.length; i++) {
            int tempMax = 1;
            for (int j=i-1; j>=0; j--) {
                if (nums[j] < nums[i]) {
                    tempMax = Math.max(tempMax, result[j] + 1);
                }
            }
            result[i] = tempMax;
            maxLength = Math.max(maxLength, tempMax);
        }
        
        return maxLength;
    }
}