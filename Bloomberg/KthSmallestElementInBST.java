/**
 *	230. Kth Smallest Element in a BST
 *	https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
class KthSmallestElementInBST {

	/**
	 * Version 1: Get inorder traversal of the BST
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return Integer.MIN_VALUE;
        }
        
        List<Integer> inorder = inorder(root);
        return inorder.get(k - 1);
    }
    
    private List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        
        List<Integer> left = inorder(root.left);
        List<Integer> right = inorder(root.right);
        
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        
        return result;
    }

    /**
     * Version 2: Use iterative inorder traversal and return the kth smallest element
     *      Time: O(k)
     *     Space: O(h)
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        Stack<TreeNode> stack = new Stack();
        TreeNode temp = root;

        int count = 0;
        while (stack.size() != 0 || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            
            temp = stack.pop();
            if (++count == k) {
                return temp.val;
            }
            temp = temp.right;
        }

        return Integer.MIN_VALUE;
    }

    /**
	 * Version 3: Add one field leftCnt to track the number of TreeNode on left subtree
	 *			  Simplify the problem to Binary Search
	 *      Time: O(h) -> h is the hright of the tree
	 *     Space: O(1)
	 */
    class TreeNode {
    	int val;
    	int leftCnt;
    	TreeNode left;
    	TreeNode right;

    	public TreeNode(int val) {
    		this.val = val;
    		leftCnt = 0;
    		left = null;
    		right = null;
    	}

    	public TreeNode(int val, int leftCnt) {
    		this.val = val;
    		this.leftCnt = leftCnt;
    		left = null;
    		right = null;
    	}
    }

	public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return Integer.MIN_VALUE;
        }
        
        while (root != null) {
        	if (root.leftCnt == k - 1) {
        		return root.val;
        	} else if (root.leftCnt > k - 1) {
        		root = root.left;
        	} else {
        		rppt = root.right;
        	}
        }

        return Integer.MIN_VALUE;
    }
}