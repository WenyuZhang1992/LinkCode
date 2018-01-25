/**
 *	95. Unique Binary Search Trees II
 *	https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 */
class UniqueBinarySearchTreesII {

	/**
	 * Version 1: Use recursion to construct BSTs;
	 *      Time:
	 *     Space:
	 */
	public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }

        return constructTrees(n, 1);
    }

    private List<TreeNode> constructTrees(int max, int min) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (min > max) {
            result.add(null);
            return result;
        }

        for (int i = min; i <= max; ++i) {
            List<TreeNode> left = constructTrees(i - 1, min);
            List<TreeNode> right = constructTrees(max, i + 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }

        return result;
    }

    /**
     * Version 2: Use Dynamic Programming and iteratively construct the tree;
     *            For every root node, its right subtree needs to add an offset of (j + 1)
     *      Time:
     *     Space:
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }

        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        dp[0].add(null);

        for (int i = 1; i < dp.length; ++i) {
            dp[i] = new ArrayList<TreeNode>();
            for (int j = 0; j < i; ++j) {
                for (TreeNode left : dp[j]) {
                    for (TreeNode right : dp[i - j - 1]) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = clone(right, j + 1);
                        dp[i].add(root);
                    }
                }
            }
        }

        return dp[n];
    }

    private TreeNode clone(TreeNode root, int offset) {
        if (root == null) {
            return null;
        }

        TreeNode node = new TreeNode(root.val + offset);
        node.left = clone(root.left, offset);
        node.right = clone(root.right, offset);
        return node;
    }
}