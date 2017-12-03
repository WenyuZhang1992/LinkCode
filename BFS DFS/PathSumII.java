/**
 *	113. Path Sum II
 *	https://leetcode.com/problems/path-sum-ii/description/
 */
class PathSumII {

	/**
	 * Version 1: Use DFS, decrease the sum by (sum - root.val)
	 *      Time: O(n) -> every node visited once
	 *     Space: O(klogn) -> k is the number of paths
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List result = new ArrayList();
        if (root == null) {
            return result;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        pathSumHelper(root, sum - root.val, result, list);
        
        return result;
    }
    
    private void pathSumHelper(TreeNode root, int target, List result, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
            pathSumHelper(root.left, target - root.left.val, result, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            pathSumHelper(root.right, target - root.right.val, result, list);
            list.remove(list.size() - 1);
        }
    }
}