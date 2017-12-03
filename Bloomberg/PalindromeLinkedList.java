/**
 *	234. Palindrome Linked List
 *	https://leetcode.com/problems/palindrome-linked-list/description/
 */
class PalindromeLinkedList {

	/**
	 * Version 1: Reverse half of the Linked List
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode end = reverse(slow);
		while (head != null && end != null) {
			if (head.val != end.val) {
				return false;
			}
			head = head.next;
			end = end.next;
		}

		return true;
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode start = head;
		ListNode mid = head.next;
		ListNode end = head.next.next;
		start.next = null;

		while (end != null) {
			mid.next = start;
			start = mid;
			mid = end;
			end = mid.next;
		}

		mid.next = start;
		return mid;
	}
}