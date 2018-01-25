/**
 *	549. Binary Tree Longest Consecutive Sequence II
 *	Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
 *  Especially, this path can be either increasing or decreasing. 
 *  For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. 
 *  On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
 */
class BinaryTreeLongestConsecutiveSequenceII {

	/**
	 * Version 1: Use recursion and Depth-First Search
	 *      Time: O(n)
	 *     Space: O(h) -> recursion needs at most O(h) for stack data structure
	 */
	int result = 0;

    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return result;
    }

    private int[] longestPath(TreeNode root) {
        if (root == null) {
            return new int[] {0,0};
        }

        int inr = 1;
        int dcr = 1;

        if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1) {
                dcr = l[1] + 1;
            }
            else if (root.val == root.left.val - 1) {
                inr = l[0] + 1;
            }
        }

        if (root.right != null) {
            int[] r = longestPath(root.right);
            if (root.val == root.right.val + 1) {
                dcr = Math.max(dcr, r[1] + 1);
            }
            else if (root.val == root.right.val - 1) {
                inr = Math.max(inr, r[0] + 1);
            }
        }

        result = Math.max(result, dcr + inr - 1);
        return new int[] {inr, dcr};
    }
}