public class Solution {
    /** Deacription: Given a binary tree, return the inorder traversal of its nodes' values.
      * 
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Version 1:
	ArrayList<Integer> output = new ArrayList<Integer>();
	
	if(root == null){
	    return output;
	}

	ArrayList<Integer> left = inorderTraversal(root.left);
	ArrayList<Integer> right = inorderTraversal(root.right);
	
	output.addAll(left);
	output.add(root.val);
	output.addAll(right);
	
	return output;

	// Version 2: without recursion
	ArrayList<Integer> output = new ArrayList<Integer>();
	
    }
}