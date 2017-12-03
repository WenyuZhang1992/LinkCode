/**
 *	543. Diameter of Binary Tree
 *	https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
class DiameterofBinaryTree {
	
	/**
	 * Version 1: Use divide and conquer
	 *      Time: O(nlogn)
	 *     Space: O(1)
	 */
	public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        
        int result = 0;
        
        int left = depth(root.left);
        int right = depth(root.right);
        int curr = left + right + 2;
        
        result = Math.max(diameterOfBinaryTree(root.left), result);
        result = Math.max(diameterOfBinaryTree(root.right), result);
        return Math.max(result, curr);
    }
    
    private int depth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        return Math.max(left, right) + 1;
    }
}