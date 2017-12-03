/**
 *	226. Invert Binary Tree
 *	https://leetcode.com/problems/invert-binary-tree/description/
 */
class InvertBinaryTree {

	/**
	 * Version 1: Use recurssion
	 *      Time: O(n)
	 *     Space: O(h) -> space used for stacks maximum of height of tree
	 */
	public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        
        root.left = left;
        root.right = right;
        
        return root;
    }

    /**
     * Version 2: Iteratively invert the Tree
     *            Use level-order traversal, invert both children
     *      Time: O(n)
     *     Space: O(n) -> If the tree is balanced, the queue will contain O(n/2) = O(n) nodes
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() != 0) {
            int count = queue.size();
            while (--count >= 0) {
                TreeNode temp = queue.poll();
                TreeNode left = temp.left;
                TreeNode right = temp.right;
                temp.left = right;
                temp.right = left;
                
                if (right != null) {
                    queue.add(right);
                }
                if (left != null) {
                    queue.add(left);
                }
            }
        }
        
        return root;
    }
}