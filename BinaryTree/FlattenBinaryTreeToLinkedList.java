/**
 *	114. Flatten Binary Tree to Linked List
 *	https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 */
class FlattenBinaryTreeToLinkedList {

	/**
	 * Version 1: Use iterative preorder traversal;
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (stack.size() != 0) {
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            
            temp.left = null;
            if (stack.size() == 0) {
                temp.right = null;
            } else {
                temp.right = stack.peek();
            }
        }
    }

    /**
	 * Version 2: Use recursion;
	 *			  Recursive method returns the last node to add its right child;
	 *      Time: O(n)
	 *     Space: O(logh) -> h is the height of the tree
	 */
	public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        convert(root);
    }

    private TreeNode convert(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;

        TreeNode lastNode = null;
        if (left != null) {
            lastNode = convert(left);
            root.right = left;
        }
        if (right != null) {
            if (lastNode == null) {
                lastNode = convert(right);
                root.right = right;
            } else {
                TreeNode temp = convert(right);
                lastNode.right = right;
                lastNode = temp;
            }
        }
        return lastNode;
    }
}