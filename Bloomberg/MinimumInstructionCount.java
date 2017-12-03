/**
 *	Minimum Count Of Instructions
 *	You are allowed to use two instructions: MUL is used to multiply 2, DIV is used to divide 3.
 *  Start with 1 and given a target value, print the instruction flow to reach the target value using minimum instructions.
 */
class MinimumInstructionCount {

	/**
	 * Version 1: Construct a Binary Tree, left child stands for MUL, right child stands for DIV
	 *      Time:
	 *     Space:
	 */
    class TreeNode {
        int val;
        String instruction;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

	public List<String> minInstructionCount(int target) {
        if (target == 1) {
            return new LinkedList<String>();
        }

        TreeNode root = new TreeNode(1);
        root.parent = null;
        List<String> result = new LinkedList<String>();
        HashSet<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        set.add(1);
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode parent = queue.poll();
            int left = parent.val * 2;
            int right = parent.val / 3;

            if (!set.contains(left)) {
                parent.left = new TreeNode(left);
                parent.left.parent = parent;
                set.add(left);
                queue.add(parent.left);
                parent.left.instruction = "MUL";
            } else {
                parent.left = null;
            }

            if (!set.contains(right)) {
                parent.right = new TreeNode(right);
                parent.right.parent = parent;
                set.add(right);
                queue.add(parent.right);
                parent.right.instruction = "DIV";
            } else {
                parent.right = null;
            }

            if (parent.left != null && parent.let.val == target) {
                addInstructions(result, parent.left);
                return result;
            }

            if (parent.right != null && parent.right.val == target) {
                addInstructions(result, parent.right);
                return result;
            }
        }

        return result;
    }

    private void addInstructions(List<String> result, TreeNode node) {
        while (node.parent != null) {
            result.addFirst(node.instruction);
            node = node.parent;
        }
    }
}