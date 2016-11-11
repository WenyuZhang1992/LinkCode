public class InsertNodeInBinarySearchTree {
    /** Description: Given a binary search tree and a new tree node, insert the node into the tree. 
      *              You should keep the tree still be a valid binary search tree.(Assume no duplicates)
      * Analysis: Key step is to find the parent of the inserted node
      *           Special case: root = null, make the inserted node to be the root
     */

    // Without recursion
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        
        TreeNode parent = root;
        
        if (root == null){
            return node;
        }
        if (root.left != null || root.right != null){
            parent = findParent(root, node.val);
        }
        
        if (parent.val > node.val)
            parent.left = node;
        else
            parent.right = node;
            
        return root;
    }
    // Help function to find the parent of the position to insert the given value
    public TreeNode findParent(TreeNode root, int value){
        TreeNode prev = root;
        TreeNode current = root;
        
        while(current != null){
            if (current.val > value){
                prev = current;
                current = current.left;
            }
            else{
                prev = current;
                current = current.right;
            }
        }
        
        return prev;
    }
    
}