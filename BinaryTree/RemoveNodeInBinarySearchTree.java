public class RemoveNodeInBinarySearchTree {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     * @Analysis: Removing a node in a BST has three situations
     *            1. Remove a leaf node: can be directly removed;
     *            2. Remove a node has one child: replace the node with the child;
     *            3. Remove a node has two children: tricky, need to find a child or grantchild 
     *               to replace the node, which is the least node is its right subtree.
     * @Notice: Need to take care of the situation when removing root.
     *          1. Root has no child, new_root = null;
     *          2. Root has one child, new_root = non-null child;
     *          3. Root has two children, merge into regular two-child situation.
     */
    static TreeNode parent;
    
    public TreeNode removeNode(TreeNode root, int value) {
        
        TreeNode del = searchNode(root, value);
        
        // No such node
        if (del == null)
            return root;
        
        
        // No child
        if (del.left == null && del.right == null){
            // Remove root
            if (del == root)
                return null;
            remove(del, parent);
            return root;
        }
        
        // One child
        if (del.left == null || del.right == null){
            // Remove root
            if (del == root){
                if (del.left == null)
                    return del.right;
                return del.left;
            }
            if (parent.left == del){
                if (del.left != null)
                    parent.left = del.left;
                else
                    parent.left = del.right;
            }
            if (parent.right == del){
                if (del.left != null)
                    parent.right = del.left;
                else
                    parent.right = del.right;
            }
            return root;
        }
        
        // Two children
        TreeNode replace;
        TreeNode temp = del;
        TreeNode temp_parent = del;
        while (temp.left != null){
            temp_parent = temp;
            temp = temp.left;
        }
        del.val = temp.val;
        remove(temp, temp_parent);
        return root;
    }
    
    public static TreeNode searchNode(TreeNode root, int value){
        if (root == null){
            parent = null;
            return root;
        }
        
        TreeNode prev = root;
        TreeNode current = root;
        while(current != null){
            if (current.val == value){
                parent = prev;
                return current;
            }
            if (current.val > value){
                prev = current;
                current = current.left;
            }
            else{
                prev = current;
                current = current.right;
            }
        }
        parent = prev;
        return null;
    }
    
    public static void remove(TreeNode child, TreeNode par){
        if (par.left == child)
            par.left = null;
        else
            par.right = null;
    }
}