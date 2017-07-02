package BinaryTree;
/**
 * Find the height of Binary Tree
 */
import java.util.*;

public class BinaryTreeHeight {
    /* Version 1: Use queue to find binary tree height iteratively
     *      Time: O(n) -> each TreeNode enqueue once and dequeue once
     */
    public static int treeHeight (TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
                count--;
            }
            height++;
        }
        return height;
    }

    public static void main(String[] argv) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(treeHeight(root));
    }
}
