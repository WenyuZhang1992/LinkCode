/**
 *	297. Serialize and Deserialize Binary Tree
 *	https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 */

/**
 * Version 1: Use level-order traversal, separate every node with ",", mark NULL as "#"
 *      Time: O(n)
 *     Space: O(n)
 */
public class SerializeDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                sb.append(temp.val).append(",");
                queue.add(temp.left);
                queue.add(temp.right);
            } else {
                sb.append("#,");
            }
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        int index = 1;
        while (queue.size() != 0) {
            TreeNode temp = queue.poll();
            
            if (temp == null) {
                continue;
            }
            
            // Deal with left node
            if (strs[index].equals("#")) {
                temp.left = null;
                queue.add(null);
            } else {
                temp.left = new TreeNode(Integer.parseInt(strs[index]));
                queue.add(temp.left);
            }
            
            // Deal with right node
            index++;
            if (strs[index].equals("#")) {
                temp.right = null;
                queue.add(null);
            } else {
                temp.right = new TreeNode(Integer.parseInt(strs[index]));
                queue.add(temp.right);
            }
            index++;
        }
        
        return root;
        
    }
}

/**
 * Version 2: Use preorder traversal, separate every node with ",", mark NULL as "#"
 *      Time: O(n)
 *     Space: O(n)
 */
public class SerializeDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack();
        
        stack.push(root);
        while (stack.size() != 0) {
            TreeNode temp = stack.pop();
            if (temp == null) {
                sb.append("#,");
            } else {
                sb.append(temp.val + ",");
                stack.push(temp.right);
                stack.push(temp.left);
            }
        }
        
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Use a queue to store all node values
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        
        String[] strs = data.split(",");
        Queue<String> nodes = new LinkedList<String>();
        
        for (String str : strs) {
            nodes.add(str);
        }
        
        return deserializaHelper(nodes);
    }
    
    private TreeNode deserializaHelper(Queue<String> nodes) {
        String temp = nodes.poll();
        if (temp.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(temp));
        node.left = deserializaHelper(nodes);
        node.right = deserializaHelper(nodes);
        
        return node;
    }
}