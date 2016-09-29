OBpublic class BinaryTreePreorderTraversal {
    /** Description: Given a binary tree, return the preorder traversal of its nodes' values.
      *
      * Analysis: Focus on without recursion version, need to use Stack and BFS.
      *
      * Notice: when root == null
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // Version 1: Without recursion
        ArrayList<Integer> output = new ArrayList();
        Stack<TreeNode> st = new Stack<TreeNode>();
    
        if(root == null){
            return output;
        }
        st.push(root);
        while(!st.empty()){
            TreeNode temp = st.pop();
            output.add(temp.val);
            if(temp.right != null){
                st.push(temp.right);
            }
            if(temp.left != null){
                st.push(temp.left);
            }
        }
        return output;

        // Version 2:
        ArrayList<Integer> output = new ArrayList<Integer>();
        if(root == null){
            return output;
        }
        
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        
        output.add(root.val);
        output.addAll(left);
        output.addAll(right);
        return output;

        // Version 3:
        ArrayList<Integer> output = new ArrayList<Integer>();
        traverse(root, output);
        return output;

        public static void traverse(TreeNode root, ArrayList<Integer> output){
            if(root == null){
                return;
            }
            output.add(root.val);
            traverse(root.left, output);
            traverse(root.right, output);
        }
    }
}