/**
 *	437. Path Sum III
 *	https://leetcode.com/problems/path-sum-iii/description/
 */
class PathSumIII {

	/**
	 * Version 1: Use a class member to record the result;
     *            Recursively check root, root.left and root.right;
	 *      Time: O(nlogn) -> each node is visited from all its ancestors
     *            O(n^2) -> worst case when tree is like a LinkedList
	 *     Space: O(h) -> h is the height of the tree
	 */
	int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null)return 0;
        helper(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return count;
    }
    
    private void helper(TreeNode root,int sum){
        if(root == null)return;
        if(root.val - sum == 0)count++;
        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
    }
}