/**
 *	572. Subtree of Another Tree
 *	https://leetcode.com/problems/subtree-of-another-tree/description/
 */
class SubtreeofAnotherTree {
	
	/**
	 * Version 1: Use DFS to get all subsets starting at certain index
	 *      Time: O(nm) -> n: nodes # of s  m: nodes # of t
	 *     Space: O(1)
	 */
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if (isSame(s, t)) {
            return true;
        }
        
        // For that t is not empty
        // so this base case will return false
        if (s == null) {
            return false;
        }
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        
        if (s == null || t == null) {
            return false;
        }
        
        if (s.val != t.val) {
            return false;
        }
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}