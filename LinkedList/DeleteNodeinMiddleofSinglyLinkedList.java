import java.util.*;

/**
 * Delete Node in the Middle of Singly Linked List
 *
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 *
 */
public class DeleteNodeinMiddleofSinglyLinkedList {

	/**
     * Version 1: Use two pointers
     *      Time: O(n)
     *     Space: O(1)
     */
	public void deleteNode(ListNode node) {
		if (node == null)
            return;
            
        node.val = node.next.val;
        node.next = node.next.next;
	}
}