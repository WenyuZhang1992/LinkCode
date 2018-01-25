/**
 *	108. Convert Sorted Array to Binary Search Tree
 *	https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
class ConvertSortedArrayToBinarySearchTree {

	/**
	 * Version 1: Use recursion;
	 *      Time: O(n)
	 *     Space: O(logn)
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return constructTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            TreeNode node = new TreeNode(nums[start]);
            return node;
        }
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums, start, mid - 1);
        root.right = constructTree(nums, mid + 1, end);
        return root;
    }
}