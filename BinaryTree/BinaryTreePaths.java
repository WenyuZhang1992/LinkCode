import java.util.*;

/**
 * Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 */

class BinaryTreePaths {
	
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<String>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }
        
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        
        for (String temp : left) {
            result.add(root.val + "->" + temp);
        }
        for (String temp : right) {
            result.add(root.val + "->" + temp);
        }
        return result;
    }
}