package BinaryTree;

import java.util.*;

public class BTLevelOrderTraversal {

    /**
     * Binary Tree Level Order Traversal: Given a binary tree,
     * return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     */

    /**
     * Version 1: Use queue
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (queue.size() != 0) {
            int count = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            while (count > 0) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                count--;
            }
            result.add(level);
        }
    }

    /**
     * Version 2: Use DFS
     */


    /**
     * Binary Tree Level Order Traversal II: Given a binary tree,
     * return the bottom-up level order traversal of its nodes' values.
     * (ie, from left to right, level by level from leaf to root).
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList result = new ArrayList();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        int size = queue.size();
        while (size != 0) {
            TreeNode temp;
            for (int i=0; i<size; i++) {
                temp = queue.poll();
                stack.push(temp);
                if (temp.right != null)
                    queue.offer(temp.right);
                if (temp.left != null)
                    queue.offer(temp.left);
            }
            stack.push(null);
            size = queue.size();
        }

        stack.pop();
        while (stack.size() != 0) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            TreeNode temp = stack.pop();
            while (temp != null) {
                level.add(temp.val);
                if (stack.size() == 0)
                    break;
                temp = stack.pop();
            }
            result.add(level);
        }
        return result;

    }

}
