/**
 *	96. Unique Binary Search Trees
 *	https://leetcode.com/problems/unique-binary-search-trees/description/
 */
class UniqueBinarySearchTrees {

	/**
	 * Version 1: Use Dynamic Programming;
     *            When we have node 1, 2, 3, ..., i, ..., n:
     *            We can construct a unique BST whose left subtree consists of [1, i - 1], right subtree consists of [i+1, n];
     *            Then, we only need to add up all unique BSTs constructed using different root node;
	 *      Time: O(n^2)
	 *     Space: O(n)
	 */
	public int numTrees(int n) {
        // Corner cases:
        // n == 0: null tree
        // n == 1: single node
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[dp.length - 1];
    }
}