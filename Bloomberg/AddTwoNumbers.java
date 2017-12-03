/**
 *	2. Add Two Numbers
 *	https://leetcode.com/problems/add-two-numbers/description/
 */
class AddTwoNumbers {

	/**
	 * Version 1: Use two pointer
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		int carry = 0;
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			tail.next = new ListNode(sum % 10);
			carry = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
			tail = tail.next;
		}

		while (l1 != null) {
			int sum = l1.val + carry;
			tail.next = new ListNode(sum % 10);
			carry = sum / 10;
			l1 = l1.next;
			tail = tail.next;
		}

		while (l2 != null) {
			int sum = l2.val + carry;
			tail.next = new ListNode(sum % 10);
			carry = sum / 10;
			l2 = l2.next;
			tail = tail.next;
		}

		if (carry > 0) {
			tail.next = new ListNode(carry);
		}

		return dummy.next;
	}
}