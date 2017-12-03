/**
 *	100. Same Tree
 *	https://leetcode.com/problems/same-tree/description/
 */
class SameTree {

	/**
	 * Version 1: Use recursion and preorder traversal(DFS)
	 *      Time: O(n)
	 *     Space: O(logn) -> recurssion stacks
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        
        if (p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
	 * Version 2: Use preorder traversal iteratively  
	 *      Time: O(n)
	 *     Space: O(logn)
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        s1.push(p);
        s2.push(q);
        while (s1.size() > 0 && s2.size() > 0) {
            TreeNode temp1 = s1.pop();
            TreeNode temp2 = s2.pop();
            
            if (temp1.val != temp2.val) {
                return false;
            }
            
            if (temp1.left != null) { 
                s1.push(temp1.left); 
            }
            if (temp2.left != null) { 
                s2.push(temp2.left); 
            } 
            if (s1.size() != s2.size()) {
                return false;
            }
            
            if (temp1.right != null) { 
                s1.push(temp1.right); 
            }
            if (temp2.right != null) { 
                s2.push(temp2.right); 
            } 
            if (s1.size() != s2.size()) {
                return false;
            }
        }
        
        return s1.size() == s2.size() ? true : false;
    }
}