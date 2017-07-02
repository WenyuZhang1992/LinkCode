package BinaryTree;

import java.util.*;

/**
 * LintCode : Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class InorderTraversal {
    /**
     * Version 1: Non-recursion method
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }

            temp = stack.pop();
            result.add(temp.val);
            temp = temp.right;
        }
        return result;
    }
}
