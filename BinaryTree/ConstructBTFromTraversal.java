package BinaryTree;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal: Given preorder and inorder traversal of a tree,
 * construct the binary tree.
 */
public class ConstructBTFromTraversal {
    /**
     * Version 1: Use recursion
     */
    static int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        if  (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[preIndex]);
        int inIndex = findIndex(inorder, preorder[preIndex]);
        preIndex++;

        if (inorder.length == 1) {
            return root;
        }

        if (inIndex >= 0) {
            int[] left = new int[inIndex];
            int[] right = new int[inorder.length - inIndex - 1];
            assignArray(preorder, left, 0);
            assignArray(preorder, right, inIndex + 1);
            root.left = buildTree(preorder, left);
            root.right = buildTree(preorder, right);
        }

        return root;
    }

    private int findIndex(int[] inorder, int targetValue) {
        if (inorder == null || inorder.length == 0)
            return -1;

        for (int i=0; i<inorder.length; i++) {
            if (targetValue == inorder[i])
                return i;
        }
        return -1;
    }

    private void assignArray(int[] inorder, int[] newArray, int startPos) {
        int size = newArray.length;
        for (int i=0; i<size; i++) {
            newArray[i] = inorder[preIndex + i + startPos];
        }
    }
}
