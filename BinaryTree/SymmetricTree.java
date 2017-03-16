import java.util.*;

class TreeNode {
	int val;
	TreeNode left, right;
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class Solution {
    /* LeetCode 101: Symmetric Tree
     *
     */
	public static void main(String args[] ) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
        System.out.println(symmetricIter(root));
    }
	
	/* Version 1: recursion
	 *            recursively check if two subtree are symmetric
	 */
	public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        return check(root.left, root.right);
    }
    
    private static boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        
        return check(left.left, right.right) && check(left.right, right.left);
    }
    
    /* Version 1: Non-recursion
	 *            Level-Traversal and check if each level is symmetric
	 */
    public static boolean symmetricIter(TreeNode root) {
    	if (root == null)
    		return true;
    	if (root.left == null && root.right == null)
    		return true;
    	if (root.left == null || root.right == null)
    		return false;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root.left);
    	queue.offer(root.right);
    	while (!queue.isEmpty()) {
    		int count = queue.size();
    		ArrayList<Integer> level = new ArrayList<Integer>();
    		for (int i=0; i<count; i++) {
    			TreeNode temp = queue.poll();
    			level.add(temp.val);
    			if (temp.left != null)
    				queue.offer(temp.left);
    			if (temp.right != null)
    				queue.offer(temp.right);
    		}
    		if (!listCheck(level))
    			return false;
    	}
    	return true;
    }
    
    private static boolean listCheck(ArrayList<Integer> list) {
    	if (list.size()%2 != 0)
    		return false;
    	int start = 0;
    	int end = list.size()-1;
    	while (start < end) {
    		if (list.get(start) != list.get(end))
    			return false;
    		start++;
    		end--;
    	}
    	return true;
    }
}