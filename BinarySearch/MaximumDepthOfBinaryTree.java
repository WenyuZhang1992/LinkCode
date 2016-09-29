public class MaximumDepthOfBinaryTree {
    /** Description:
      * Given a binary tree, find its maximum depth.
	  * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	  *
	  * Analysis: Use recursion
	  *           Two base cases: 1. root == null, return 0;
	  *                           2. root is a leaf, return 1;
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root== null){
        	return 0;
        }
        else if (root.right == null && root.left == null){
            return 1;
        }
        else{
        	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}