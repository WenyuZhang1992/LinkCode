package BinaryTree;
/**
 * BinaryTree.Zigzag traversal of Binary Tree
 */
import java.util.*;

public class Zigzag {
    public static ArrayList<Integer> zigZag(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Special cases
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 1;
        queue.offer(root);
        while (queue.size() != 0) {
            int count = queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i=0; i<count; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            if (level == 1 || level%2 == 0)
                result.addAll(list);
			else {
                    for (int j=list.size()-1; j>=0; j--) {
                        result.add(list.get(j));
                    }
                }
                level++;
        }
        return result;
    }

    public static void main(String[] argv) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<Integer> result = zigZag(root);
        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
