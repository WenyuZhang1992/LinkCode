public class SearchRangeInBinarySearchTree {
    /** Description: Given two values k1 and k2 (where k1 < k2) and a root pointer 
      *              to a Binary Search Tree. Find all the keys of tree in range k1 to k2. 
      *              i.e. print all x such that k1<=x<=k2 and x is a key of given BST. 
      *              Return all the keys in ascending order.
      * Analysis: Three situations
      *           1. When root.val < k1, the desired values can only be right side of root;
      *           2. When root.val > k2, the desired values can only be left side of root;
      *           3. When root.val inside range [k1, k2], the desired values can be both sides.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        
        // Base case
        if (root == null)
            return output;
        
        // Divide and Conquer
        if (root.val < k1){
            output.addAll(searchRange(root.right, k1, k2));
        }
        else if (root.val > k2){
            output.addAll(searchRange(root.left, k1, k2));
        }
        else{
            output.addAll(searchRange(root.left, k1, k2));
            output.add(root.val);
            output.addAll(searchRange(root.right, k1, k2));
        }
        
        return output;
    }
}