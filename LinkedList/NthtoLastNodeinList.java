import java.util.*;

/**
 * Nth to Last Node in List
 *
 * Find the nth to last element of a singly linked list. 
 * The minimum number of nodes in list is n.
 *
 */
public class NthtoLastNodeinList {

	/**
     * Version 1: Use two pointers
     *      Time: O(n)
     *     Space: O(1)
     */
	ListNode nthToLast(ListNode head, int n) {
		if (head == null)
			return head;

		ListNode start = head;
		ListNode end = head;

		for (int i=0; i<n; i++) {
			end = end.next;
		}

		while (end != null) {
			start = start.next;
			end = end.next;
		}

		return start;
	}
}