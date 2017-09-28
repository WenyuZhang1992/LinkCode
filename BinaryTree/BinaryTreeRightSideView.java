/**
 *	199. Binary Tree Right Side View
 *	https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
class BinaryTreeRightSideView {

	/**
	 * Version 1: Use BFS, level traversal to find rightest element of every level
	 *      Time: O(n)
	 *     Space: O(logn)
	 */
	public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        while (queue.size() != 0) {
            int count = queue.size();
            for (int i=0; i < count; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                
                if (i == count - 1) {
                    result.add(temp.val);
                }
            }
        }
        
        return result;
    }
}