/**
 *  Given a DOM Tree represented as a String,
 *  1. Check if the input String is a valid DOM Tree;
 *  2. Represent the DOM Tree using TreeNode objects;
 *
 */
class DOMTree {

    /**
     * Problem 1: Use stack to hold OpeningTags
     *      Time: O(n)
     *     Space: O(n)
     */
    public boolean validDomtree(String input) {
        if (input == null || input.length() == 0) {
            return true;
        }

        Stack<String> stack = new Stack<String>();

        int start = 0;
        int end = 1;

        while (start < input.length() && end < input.length()) {
            if (input.charAt(start) == '<') {
                end = start + 1;

                while (end < input.length()) {
                    if (input.charAt(end) == '>') {
                        String temp = input.substring(start, end + 1);
                        // If OpeningTag
                        if (isOpeningTag(temp)) {
                            stack.push(temp);
                        } else {
                            // If ClosedTag
                            if (stack.size() == 0) { return false; }
                            if (!isMatched(stack.pop(), temp)) { return false; }
                        }
                        break;
                    }
                    end++;
                }
                start = end + 1;
            } else {
                start++;
            }
        }

        return stack.size() == 0;
    }

    /**
     * Problem 2: Use stack to hold constructed DOMTreeNode;
     *            If OpeningTag, construct a DOMTreeNode and push into stack;
     *            If ClosedTag, pop out from stack check if they are matched; 
     *            If matched, the parent node of current node is on the peek of the stack, if stack is empty, this node is the root;
     *            Use a StringBuilder to keep track of text contents, since valid text only occurs between two tags, insert the text when the node is popped out;
     *      Time: O(n)
     *     Space: O(n)
     */
    class DOMTreeNode {
        String text;
        ArrayList<DOMTreeNode> children;
        String tag;

        public DOMTreeNode (String tag) {
            this.tag = tag;
            children = new ArrayList<DOMTreeNode>();
        }
    }

    public DOMTreeNode toDOMTree(String input) throws Exception {
        if (input == null || input.length() == 0) {
            return null;
        }

        Stack<DOMTreeNode> stack = new Stack<DOMTreeNode>();

        DOMTreeNode root = new DOMTreeNode("Pointer");
        int start = 0;
        int end = 1;
        StringBuilder sb = new StringBuilder();

        while (start < input.length() && end < input.length()) {
            if (input.charAt(start) == '<') {
                end = start + 1;

                while (end < input.length()) {
                    if (input.charAt(end) == '>') {
                        String temp = input.substring(start, end + 1);

                        // If OpeningTag
                        if (isOpeningTag(temp)) {
                            DOMTreeNode node = new DOMTreeNode(temp);
                            stack.push(node);
                        } else {
                            // If ClosedTag
                            if (stack.size() == 0) { throw new Exception("Invalid DOM Tree"); }

                            DOMTreeNode currNode = stack.pop();
                            if (!isMatched(currNode.tag, temp)) {
                                throw new Exception("Invalid DOM Tree");
                            } else {

                                // Add text
                                if (sb.length() != 0) {
                                    currNode.text = sb.toString();
                                    sb = new StringBuilder();
                                }
                                
                                if (stack.size() == 0) {
                                    root = currNode;
                                } else {
                                    stack.peek().children.add(currNode);
                                }
                            }
                        }
                        break;
                    }
                    end++;
                }
                start = end + 1;
            } else {
                sb.append(input.charAt(start++));
            }
        }

        if (stack.size() != 0) {
            throw new Exception("Invalid DOM Tree");
        }
        return root;
    }

    public void traverse(DOMTreeNode root, int indent, String indents = "                   ") {
        if (root == null) {
            return;
        }

        System.out.print(new String(indents.toCharArray(), 0, indent) + root.tag);
        if (root.text != null) {
            System.out.println(root.text);
        } else {
            System.out.print("\n");
        }
        for (DOMTreeNode node : root.children) {
            traverse(node, indent + 2, indents);
        }
    }

    private boolean isOpeningTag(String tag) {
        return tag.charAt(1) != '/';
    }

    private boolean isMatched(String open, String end) {
        return open.substring(1).equals(end.substring(2));
    }
}