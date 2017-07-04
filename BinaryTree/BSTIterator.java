package BinaryTree;

import java.util.*;

/**
 * Binary Search Tree Iterator
 * Design an iterator over a binary search tree with the following rules:
 * 1. Elements are visited in ascending order (i.e. an in-order traversal);
 * 2. next() and hasNext() queries run in O(1) time in average.
 */
public class BSTIterator {

	private TreeNode root;
	private Stack<TreeNode> stack;
	private TreeNode temp;

	public BSTIterator(TreeNode root) {
		this.root = root;
		stack = new Stack<TreeNode>();
		temp = root;
	}

	public boolean hasNext() {
		return (stack.size() != 0 || temp != null);
	}

	public TreeNode next() {
		while (temp != null) {
			stack.push(temp);
			temp = temp.left;
		}
		TreeNode next = stack.pop();
		temp = next.right;
		return next;
	}
}