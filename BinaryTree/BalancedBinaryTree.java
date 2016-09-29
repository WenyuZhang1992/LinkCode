class BalancedBinaryTree {
    /** Description: Given a binary tree, determine if it is height-balanced.
      * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two * subtrees of every node never differ by more than 1.
      *
      * Analysis: Use Divide-Conquer
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }
        
        if(Math.abs(treeDepth(root.left)-treeDepth(root.right))>1){
            return false;
        }
        else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    public int treeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        return 1 + Math.max(treeDepth(root.left),treeDepth(root.right));
    }
}