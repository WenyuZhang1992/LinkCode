/**
 *	173. Binary Search Tree Iterator
 *	https://leetcode.com/problems/binary-search-tree-iterator/description/
 */

/**
 * Version 1: Use inorder traversal 
 *      Time: O(n)
 *     Space: O(n)
 */
public class BSTIterator {
    
    Stack<TreeNode> stack;
    TreeNode root;
    TreeNode temp;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        this.root = root;
        temp = root;
    }

    public boolean hasNext() {
        return stack.size() != 0 || temp != null;
    }

    public int next() {
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        TreeNode next = stack.pop();
        temp = next.right;
        return next.val;
    }
}