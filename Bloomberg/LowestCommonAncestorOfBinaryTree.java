/**
 *	236. Lowest Common Ancestor of a Binary Tree
 *	https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
class LowestCommonAncestorOfBinaryTree {

	/**
	 * Version 1: Use Divide and Conquer
	 *      Time: O(n)
	 *     Space: O(h)
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		} 

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		} else if (left == null) {
			return right;
		} else {
			return left;
		}
	}
}