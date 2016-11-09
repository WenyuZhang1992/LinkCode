public class ValidateBinarySearchTree {
    /**
     *  Analysis: Remember that the inorderTraversal of a Validate Binary Search Tree is in ascending order!
     *            Firstly obtain the inorder traversal of the tree, then compare the elements one by one.
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        
        ArrayList<Integer> order = inorderTraversal(root);
        for (int i=1; i<order.size(); i++){
            if (order.get(i-1) >= order.get(i)){
                return false;
            }
        }
        return true;
    }
    
    // Method to obtain
    public ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> output = new ArrayList<Integer>();
        if (root == null)
            return output;
        if (root.left == null && root.right == null){
            output.add(root.val);
            return output;
        }
        
        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);
        
        output.addAll(left);
        output.add(root.val);
        output.addAll(right);
        
        return output;
        
    }
}