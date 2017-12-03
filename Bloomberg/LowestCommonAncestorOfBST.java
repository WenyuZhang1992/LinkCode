/**
 *  235. Lowest Common Ancestor of a Binary Search Tree
 *  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
class LowestCommonAncestorOfBST {

    /**
     * Version 1: Iteratively traverse the BST
     *      Time: O(logn)
     *     Space: O(1)
     */
    public TreeNode lowestCommonAncestorIter(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // make sure p has smaller value than q
        if (p.val > q.val) {
            return lowestCommonAncestorIter(root, q, p);
        }

        TreeNode pointer = root;
        while (pointer != null) {
            if (pointer.val >= p.val && pointer.val <= q.val) {
                return pointer;
            } else if (pointer.val > q.val) {
                pointer = pointer.left;
            } else {
                pointer = pointer.right;
            }
        }

        return null;
    }

    /**
     * Version 2: Recursively traverse the BST
     *      Time: O(logn)
     *     Space: O(1)
     */
    public TreeNode lowestCommonAncestorRecv(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        if (p.val > q.val) {
            return lowestCommonAncestorRecv(root, q, p);
        }

        if (root.val > q.val) {
            return lowestCommonAncestorRecv(root.left, p, q);
        } else if (root.val < p.val){
            return lowestCommonAncestorRecv(root.right, p, q);
        } else {
            return root;
        }
    }
}