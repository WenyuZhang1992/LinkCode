/**
 *	Coincident Tree Node:
 *	Given a Binary Tree, check if the tree contains coincident nodes;
 *  Coincident nodes are nodes that are inside the same level and same column;
 *
 *  For example:
 *         1
 *        / \
 *       2   3
 *      /\   /\
 *     4  5  6 7
 *
 *  In this Binary Tree, Node 5 and Node 6 are coincident nodes;
 */
class CoincidentTree {

	/**
	 * Version 1: Use level-order traversal, so we can check the level;
	 *            Use another queue to hold the column count of each node, coincident nodes exist if same column counts occurs within single level traversal;
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public boolean isCoincident(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nQueue = new LinkedList<TreeNode>();
        Queue<Integer> iQueue = new LinkedList<Integer>();

        nQueue.add(root);
        iQueue.add(0);
        while (nQueue.size() != 0 && iQueue.size() != 0) {
            int count = nQueue.size();
            int prevColumn = Integer.MIN_VALUE;
            while (count-- > 0) {
                TreeNode temp = nQueue.poll();
                int currColumn = iQueue.poll();

                if (currColumn == prevColumn) {
                    System.out.println(currColumn);
                    return true;
                } else {
                    prevColumn = currColumn;
                }

                if (temp.left != null) {
                    nQueue.add(temp.left);
                    iQueue.add(currColumn - 1);
                }
                if (temp.right != null) {
                    nQueue.add(temp.right);
                    iQueue.add(currColumn + 1);
                }
            }
        }

        return false;
    }
}