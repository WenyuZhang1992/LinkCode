/**
 *	98. Validate Binary Search Tree
 *	https://leetcode.com/problems/validate-binary-search-tree/description/
 */
class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
        if (root == null) {
        	return true;
        }
        if (root.left == null && root.right == null) {
        	return true;
        }

        List<Integer> inorder = inorder(root);
        for (int i = 1; i < inorder.size(); i++) {
        	if (inorder.get(i) <= inorder.get(i-1)) {
        		return false;
        	}
        }

        return true;
    }

    /**
	 * Version 1: Use recursion
	 *      Time: O(n)
	 *     Space: O(1)
	 */
    private List<Integer> inorderRecv(TreeNode root) {
    	if (root == null) {
    		return new ArrayList<Integer>();
    	}

    	List<Integer> left = inorder(root.left);
    	List<Integer> right = inorder(root.right);

    	List<Integer> result = new ArrayList<Integer>();
    	result.addAll(left);
    	result.add(root.val);
    	result.addAll(right);

    	return result;
    }

    /**
	 * Version 2: Iteratively obtain inorder traversal of BST
	 *      Time: O(n)
	 *     Space: O(1)
	 */
    private List<Integer> inorderIter(TreeNode root) {
    	if (root == null) {
    		return new ArrayList<Integer>();
    	}

    	List<Integer> result = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack();
    	TreeNode temp = root;
    	while (stack.size() > 0 || temp != null) {
    		if (temp != null) {
    			stack.push(temp);
    			while (temp.left != null) {
    				stack.push(temp.left);
    				temp = temp.left;
    			}
    		}

    		temp = stack.pop();
    		result.add(temp.val);
    		temp = temp.right;
    	}

    	return result;
    }
}