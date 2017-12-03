/**
 *	206. Reverse Linked List
 *	https://leetcode.com/problems/reverse-linked-list/description/
 */
class ReverseLinkedList {

	/**
	 * Version 1: Use 3 pointers to reverse the linked list iteratively
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public ListNode reverseListIter(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode start = head;
		ListNode mid = head.next;
		ListNode end = mid.next;
		head.next = null;

		while (end != null) {
			mid.next = head;
			head = mid;
			mid = end;
			end = end.next;
		}

		mid.next = head;
		return mid;
	}

	/**
	 * Version 2: Use recursion
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public ListNode reverseListRecv(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		 
		ListNode parent = reverseListRecv(head.next);
		head.next.next = head;
		head.next = null;
		return parent;
	}
}