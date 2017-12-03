/**
 *	Convert a BST to a sorted circular doubly-linked list in-place. 
 *  Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
 */
class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class BSTToDLL {

    /** Version 1: Use recursion in place
     *       Time: O(n)
     *      Space: O(1)
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);

        // Mark root as a Doubly Linked List Node
        root.left = root;
        root.right = root;

        return concatDoublyList(concatDoublyList(left, root), right);
    }

    private Node concatDoublyList(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Node leftLast = l1.left;
        Node rightLast = l2.left;

        l1.left = rightLast;
        rightLast.right = l1;

        leftLast.right = l2;
        l2.left = leftLast;

        return l1;
    }

    public void display(Node head) {
        System.out.println("Circular Linked List is :");
        Node itr = head;
        do
        {
            System.out.print(itr.val+ " " );
            itr = itr.right;
        }
        while (itr != head);
        System.out.println();
    }

    public static void main(String args[]) {

        BSTToDLL list = new BSTToDLL();

        Node root = new Node(15);
        root.left = new Node(12);
        root.right = new Node(17);
        root.left.left = new Node(11);
        root.left.right = new Node(14);
        root.right.left = new Node(16);

        // head refers to the head of the Link List
        Node head = list.treeToDoublyList(root);

        // Display the Circular LinkedList
        list.display(head);
    }
}