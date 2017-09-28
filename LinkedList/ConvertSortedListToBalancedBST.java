import java.util.*;

/**
 * Convert Sorted List to Balanced BST
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 */

class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class ConvertSortedListToBalancedBST {

	public static ListNode curr;
	/** Version 1: Use Recursion to form BST from top to bottom
     *       Time: O(nlogn) -- Binaru Search Tree depth will be O(logn)
     *                         But every time we need to traverse the list which takes O(n)
     *      Space: O(1)
     */
	public static TreeNode sortedListToBST(ListNode head) {
		int length = getListLength(head);
		return sortedListToBSTHelper(head, length);
	}

	private static int getListLength(ListNode head) {
		if (head == null)
			return 0;

		ListNode tail = head;
		int length = 0;
		while (tail != null) {
			length++;
			tail = tail.next;
		}
		return length;
	}

	private static TreeNode sortedListToBSTHelper(ListNode head, int length) {
		if (length == 0 || head == null) {
			return null;
		}
		if (length == 1) {
			return new TreeNode(head.val);
		}

		int headPosition = length / 2;
		int count = headPosition;
		ListNode parent = head;
		ListNode current = head;

		while (count != 0) {
			parent = current;
			current = current.next;
			count--;
		}

		TreeNode root = new TreeNode(current.val);
		parent.next = null;
		root.left = sortedListToBSTHelper(head, headPosition);
		root.right = sortedListToBSTHelper(current.next, length - headPosition - 1);
		return root;
	}

	/** Version 2: Use Recursion to form BST from bottom to top, takes use of a static copy of head
     *       Time: O(n)
     *      Space: O(1)
     */
	public static TreeNode sortedListToBSTB2T(ListNode head) {
		curr = head;
		int length = getListLength(head);
		return sortedListToBSTHelper1(length);
	}

	private static TreeNode sortedListToBSTHelper1(int length) {
		if (length <= 0) {
			return null;
		}

		TreeNode left = sortedListToBSTHelper1(length / 2);
		TreeNode root = new TreeNode(curr.val);
		root.left = left;
		curr = curr.next;
		root.right = sortedListToBSTHelper1(length - length / 2 - 1);

		return root;
	}

	public static void main(String[] argv) {
		ListNode head = new ListNode(-1);
		head.next = new ListNode(1);
		TreeNode root = sortedListToBSTB2T(head);
		System.out.println(root.val);
		if (root.left != null) {
			System.out.println(root.left.val);
		}
		if (root.right != null) {
			System.out.println(root.right.val);
		}
	}
}