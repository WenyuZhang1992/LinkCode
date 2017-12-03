/**
 *	110. Balanced Binary Tree
 *	https://leetcode.com/problems/balanced-binary-tree/description/
 */
class BalancedBinaryTree {

	/**
	 * Version 1: Use recursion
	 *      Time: 
	 *     Space:
	 */
	public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}