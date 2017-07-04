package BinaryTree;

import java.util.*;

/**
 * Problems regarding Binary Search Tree
 */
public class BinarySearchTree {

    /**
     * Validate Binary Search Tree: Given a binary tree, determine if it is a valid binary search tree
     */
    public boolean isValidBST(BinaryTree.TreeNode root) {
        ArrayList<Integer> inorderSeq = inorderTraversal(root);

        for (int i=0; i<inorderSeq.size()-1; i++) {
            if (inorderSeq.get(i+1) <= inorderSeq.get(i))
                return false;
        }

        return true;
    }

    private ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }

    /**
     * Search Range in Binary Search Tree: Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree.
     *                                     Find all the keys of tree in range k1 to k2
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

        // Situation 1:
        if (root.val < k1) {
            result.addAll(result.size(), searchRange(root.right, k1, k2));
        }

        // Situation 2:
        if (root.val > k2) {
            result.addAll(0, searchRange(root.left, k1, k2));
        }

        // Situation 3:
        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
            result.addAll(result.size(), searchRange(root.right, k1, k2));
            result.addAll(0, searchRange(root.left, k1, k2));
        }

        return result;
    }

    /**
     * Find specific TreeNode in BST
     */
    public TreeNode findNode(TreeNode root, int value) {

        TreeNode current = root;
        TreeNode parent = current;

        while (current != null) {
            if (current.val == value) {
                return current;
            } else if (current.val > value) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        return parent;
    }

    /**
     * Insert TreeNode into BST
     */    
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null)
            return node;

        TreeNode parent = findNode(root, node.val);
        if (node.val > parent.val) {
            parent.right = node;
        } else {
            parent.left = node;
        }

        return root;
    } 

}
