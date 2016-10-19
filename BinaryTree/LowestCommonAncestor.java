public class LowestCommonAncestor {
    /** Description: Given the root and two nodes in a Binary Tree. 
     *               Find the lowest common ancestor(LCA) of the two nodes.
     *               The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
     *  Analysis: A and B can totally have 3 kind of distributing situations
     *            1. One of them is the root, so the LCA is root;
     *            2. Both of them in the same subtree, so the LCA is A or B;
     *            3. A and B are in two different subtrees, so the LCA is the root;
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null){
            return null;
        }
        if (A == root || B == root){
            return root;
        }
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        // Conquer
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }
}