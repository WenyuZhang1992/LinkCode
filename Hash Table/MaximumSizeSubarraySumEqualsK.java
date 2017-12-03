/**
 *	325. Maximum Size Subarray Sum Equals k
 *	Given an array nums and a target value k, 
 *  find the maximum length of a subarray that sums to k. 
 *  If there isn't one, return 0 instead.
 *
 *  Example: Given nums = [-2, -1, 2, 1], k = 1,
 *           return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 */
class MaximumSizeSubarraySumEqualsK {
	
	/**
	 * Version 1: Use Dynamic Programming
     *            dp[i] means sum from head till nums[i]
     *            Find a j satisfies that dp[i] - dp[j] == k, record the subarray length
	 *      Time: O(n^2)
	 *     Space: O(1)
	 */
	public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int length = 0;
        
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = nums[i] + dp[i];
            for (int j = 0; j <= i; j++) {
                if (dp[i + 1] - dp[j] == k) {
                    length = Math.max(length, i - j + 1);
                }
            }
        }

        return length;
    }

    /**
     * Version 1: Use HashTable and accumulative sum
     *      Time: O(n)
     *     Space: O(n)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap();
        map.put(k, 0);
        int[] sums = new int[nums.length + 1];
        int length = 0;

        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
            if (map.containsKey(sums[i + 1])) {
                length = Math.max(length, i + 1 - map.get(sums[i + 1]));
            } else {
                map.put(sums[i + 1] + k, i + 1);
            }
        }

        return length;
    }
    
}