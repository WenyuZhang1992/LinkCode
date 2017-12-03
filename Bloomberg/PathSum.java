/**
 *	112. Path Sum
 *	https://leetcode.com/problems/path-sum/description/
 */
class PathSum {

	/**
	 * Version 1: Use DFS, decrease the sum by (sum - root.val)
	 *      Time: O(n) -> every node visited once
	 *     Space: O(klogn) -> k is the number of paths
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}