/**
 *  298. Binary Tree Longest Consecutive Sequence
 *  Given a binary tree, find the length of the longest consecutive sequence path.
 *  The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
 *  The longest consecutive path need to be from parent to child (cannot be the reverse).
 */
class BinaryTreeLongestConsecutiveSequence {

    /**
     * Version 1: Use recursion and Depth-First Search
     *      Time: O(n)
     *     Space: O(h) -> recursion needs at most O(h) for stack data structure
     */
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = Math.max(dfs(root.left, root, 1), dfs(root.right, root, 1));
        return result;
    }

    public int dfs(TreeNode curr, TreeNode parent, int length) {
        if (curr == null) {
            return length;
        }

        if (curr.val == parent.val + 1) {
            length = length + 1;
        } else {
            length = 1;
        }

        return Math.max(dfs(curr.left, curr, length), dfs(curr.right, curr, length));
    }

    /**
     * Version 2: Use iterative version with queues and BFS;
     *      Time: O(n)
     *     Space: O(n)
     */
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nQueue = new LinkedList();
        Queue<Integer> lQueue = new LinkedList();
        int result = 0;

        nQueue.add(root);
        lQueue.add(1);
        while (nQueue.size() != 0) {
            TreeNode temp = nQueue.poll();
            int length = lQueue.poll();
            result = Math.max(result, length);

            if (temp.left != null) {
                if (temp.left.val == temp.val + 1) {
                    nQueue.add(temp.left);
                    lQueue.add(length + 1);
                } else {
                    nQueue.add(temp.left);
                    lQueue.add(1);
                }
            }

            if (temp.right != null) {
                if (temp.right.val == temp.val + 1) {
                    nQueue.add(temp.right);
                    lQueue.add(length + 1);
                } else {
                    nQueue.add(temp.right);
                    lQueue.add(1);
                }
            }
        }

        return result;
    }
}