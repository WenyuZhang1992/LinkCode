/**
 *	235. Lowest Common Ancestor of a Binary Search Tree
 *	https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
class LowestCommonAncestorofBinarySearchTree {

	/**
	 * Version 1: Use recursion
	 *      Time: O(logn)
	 *     Space: O(1)
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        if (p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (q.val < root.val && root.val > p.val) {
            return root;
        }

        return null;
    }
}