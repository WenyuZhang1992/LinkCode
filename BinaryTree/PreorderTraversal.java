package BinaryTree;

import java.util.*;

/**
 * LintCode <url>https://www.lintcode.com/en/problem/binary-tree-preorder-traversal/</url>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class PreorderTraversal {

    /**
     * Version 1: Use recursion and divide-and-conquer
     *      Time: O(logn)
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        ArrayList result = new ArrayList<Integer>();

        ArrayList left = preorderTraversal(root.left);
        ArrayList right = preorderTraversal(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;
    }

    /**
     * Version 2: Non-recursion method
     *      Time: O(n)
     *     Space: O(1)
     */
    public ArrayList<Integer> preorderTraversalNonRecurssion(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        ArrayList result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);

            if (temp.left != null)
                stack.push(temp.left);
            if (temp.right != null)
                stack.push(temp.right);
        }

        return result;
    }

    public static void main(String[] argv) {

    }
}
