/**
 *	101. Symmetric Tree
 *	https://leetcode.com/problems/symmetric-tree/description/
 */
class SymmetricTree {

	/**
	 * Version 1: Recursively check two subtrees
	 *      Time: O(n)
	 *     Space: O(logn)
	 */
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
        	return true;
        }

        if (root.left == null && root.right == null) {
        	return true;
        }

        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
    	if (left == null && right == null) {
    		return true;
    	} else if (left == null || right == null) {
    		return false;
    	}

    	if (left.val != right.val) {
    		return false;
    	}

    	return isSame(left.left, right.right) && isSame(left.right, right.left);
    }

    /**
	 * Version 2: Iteratively use queue
	 *      Time: O(n)
	 *     Space: O(logn)
	 */
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
        	return true;
        }

        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root.left);
        q2.add(root.right);

        while (q1.size() != 0 && q2.size() != 0) {
        	TreeNode t1 = q1.poll();
        	TreeNode t2 = q2.poll();
            if (t1 == null && t2 == null) {
                continue;
            } else if (t1 == null || t2 == null) {
                return false;
            }
            
        	if (t1.val != t2.val) { return false; }
        	q1.add(t1.left);
        	q1.add(t1.right);
        	q2.add(t2.right);
        	q2.add(t2.left);
        }

        return q1.size() == q2.size() ? true : false;
    }
}