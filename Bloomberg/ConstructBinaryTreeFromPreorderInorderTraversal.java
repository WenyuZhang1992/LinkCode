/**
 *	105. Construct Binary Tree from Preorder and Inorder Traversal
 *	https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
class ConstructBinaryTreeFromPreorderInorderTraversal {

	/**
	 * Version 1: Use Min Heap to store only K elements
	 *      Time: O(n^2) -> traverse every node once O(n)
	 *                   -> at each node, findRoot() takes O(n)
	 *            Worst case -> left-skewed binary tree, all roots locate at end of search range of inorder 
	 *     Space: O(logn)
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart || inEnd < inStart) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = findRoot(inorder, preorder[preStart]);
            
        root.left = buildTree(preorder, preStart + 1, preStart + (index - inStart), inorder, inStart, index - 1);
        root.right = buildTree(preorder, preStart + (index - inStart) + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
    
    private int findRoot(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
}