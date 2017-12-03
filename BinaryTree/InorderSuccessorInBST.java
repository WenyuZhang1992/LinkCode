/**
 *	Inorder Successor in BST
 *	Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 *  Note: If the given node has no in-order successor in the tree, return null.
 */
class InorderSuccessorInBST {

	/**
	 * Version 1: 
	 *      Time: O(nlogn) -> O(logn) for minHeap operation, need to operate O(n) times
	 *     Space: O(1)
	 */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack();
        TreeNode temp = root;
        while (stack.size() != 0 || temp != null) {
            
        }
    }
}