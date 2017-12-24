/**
 *  307. Range Sum Query - Mutable
 *  https://leetcode.com/problems/range-sum-query-mutable/description/
 */

/**
 * Version 1: Use Segment Tree
 *      Time: O(n) -> For constructing the Segment Tree
 *            O(logn) -> For update and sumRange operations
 *     Space: O(n) -> For the space of the tree
 */
class NumArray {

    class TreeNode {
        int start;
        int end;
        int sum;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;

            left = null;
            right = null;
        }
    }

    TreeNode root;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        root = constructTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructTree(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(i, j, nums[i]);
        }

        TreeNode root = new TreeNode(i, j, 0);
        root.left = constructTree(nums, i, i + (j - i) / 2);
        root.right = constructTree(nums, i + (j - i) / 2 + 1, j);
        root.sum = root.left.sum + root.right.sum;

        return root;
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(TreeNode node, int position, int value) {
        if (node.start == position && node.end == position) {
            node.sum = value;
            return;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (position <= mid) {
            update(node.left, position, value);
        } else {
            update(node.right, position, value);
        }

        node.sum = node.left.sum + node.right.sum;
    }
    
    public int sumRange(int i, int j) {
        if (i > j) {
            return Integer.MIN_VALUE;
        }
        if (i < root.start || j > root.end) {
            return Integer.MIN_VALUE;
        }

        return sumRange(root, i, j);
    }

    private int sumRange(TreeNode node, int i, int j) {
        if (node.start == i && node.end == j) {
            return node.sum;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (j <= mid) {
            return sumRange(node.left, i, j);
        } else if (i > mid) {
            return sumRange(node.right, i, j);
        } else {
            return sumRange(node.left, i, mid) + sumRange(node.right, mid + 1, j);
        }
    }
}
