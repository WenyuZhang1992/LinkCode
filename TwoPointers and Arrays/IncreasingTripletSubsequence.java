/**
 *	334. Increasing Triplet Subsequence
 *	https://leetcode.com/problems/increasing-triplet-subsequence/description/
 */
class IncreasingTripletSubsequence {
	
	/**
	 * Version 1: Use Dynamic Programming
     *            dp[i] stands for maximum length of increasing subsequence ending at position i
     *            Traverse all dp[j] when j < i, update dp[i]
	 *      Time: O(n^2)
	 *     Space: O(n)
	 */
	public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            if (dp[i] >= 3) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Version 2: Use two arrays store the minValue from 0 - i and maxValue from i - n
     *            Check if there is small[i] < nums[i] < large[i]
     *      Time: O(n)
     *     Space: O(n)
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int[] small = new int[nums.length];
        int[] large = new int[nums.length];
        small[0] = nums[0];
        large[large.length - 1] = nums[nums.length - 1];

        for (int i=1; i < nums.length; i++) {
            small[i] = Math.min(small[i - 1], nums[i]);
        }
        
        for (int j = nums.length - 2; j >= 0; j--) {
            large[j] = Math.max(large[j + 1], nums[j]);
        }

        for (int index = 0; index < nums.length; index++) {
            if (small[index] < nums[index] && nums[index] < large[index]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Version 3: Use Two Pointers, assign them with Integer.MAX_VALUE
     *            Traverse through the array, until we update p1, p2 and then find another larger value
     *            p1 -> minimum value to current position
     *            p2 -> a value who has at least one smaller value ahead
     *      Time: O(n)
     *     Space: O(1)
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;

        for (int i : nums) {
            if (p1 >= i) {
                p1 = i;
            } else if (p2 >= i) {
                p2 = i;
            } else {
                return true;
            }
        }

        return false;
    }
}