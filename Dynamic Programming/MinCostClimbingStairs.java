/**
 *	746. Min Cost Climbing Stairs
 *	https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
class MinCostClimbingStairs {

	/**
	 * Version 1: Use Dynamic Programming;
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; ++i) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[dp.length - 1];
    }

    /**
     * Version 2: Use Dynamic Programming with constant space;
     *            Since we can only climb 1 or 2 stairs, we only need to keep track of two dp values;
     *      Time: O(n)
     *     Space: O(1)
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        int dp1 = 0;
        int dp2 = 0;

        for (int i = 2; i <= cost.length; ++i) {
            int temp = Math.min(dp1 + cost[i - 1], dp2 + cost[i - 2]);
            dp2 = dp1;
            dp1 = temp;
        }
        return dp1;
    }
}