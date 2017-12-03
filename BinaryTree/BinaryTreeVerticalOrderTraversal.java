/**
 *	Binary Tree Vertical Order Traversal
 *	Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *  If two nodes are in the same row and column, the order should be from left to right.
 */
class BinaryTreeVerticalOrderTraversal {
	
    /**
     * Version 1: Use DFS and HashTable
     *            For a TreeNode, its left child locates in (col-1);
     *                            its right child locates in (col+1);
     *            Use a HashMap to store all vertical columns with key=col
     *            Add columns of values from minCol to maxCol
     *      Time: O(n)
     *     Space: O(n)
     */
	public List<List<Integer>> verticalOrder(TreeNode root) { 
        List result = new ArrayList();
        if (root == null) {
            return result;
        }

        HashMap<Integer, List<String>> map = new HashMap();
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
        Queue<Integer> cols = new LinkedList<TreeNode>();

        queue.add(root);
        cols.add(0);

        int min = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            int col = cols.poll();

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(temp.val);

            if (temp.left != null) {
                queue.add(temp.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }

            if (temp.right != null) {
                queue.add(temp.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i=min; i <= max; i++) {
            result.add(map.get(i));
        }

        return result;
    }
}