package BinaryTree; /**
 * LeetCode 173: Binary Search Tree Iterator
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 */

import java.util.*;

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private TreeNode current;

    public BSTIterator(TreeNode root) {
        current = root;
    }

    public boolean hasNext() {
        return (current != null || !stack.empty());
    }

    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        TreeNode next = stack.pop();
        current = next.right;
        return next.val;
    }

    // For test only
    public static void main(String[] argv) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        BSTIterator iter = new BSTIterator(root);
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (iter.hasNext())
            result.add(iter.next());
        for (int i : result)
            System.out.print(i + " ");
    }
}
