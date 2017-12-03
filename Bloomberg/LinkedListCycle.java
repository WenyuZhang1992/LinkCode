/**
 *	141. Linked List Cycle
 *	https://leetcode.com/problems/linked-list-cycle/description/
 */
class LinkedListCycle {

	/**
	 * Version 1: Use fast and slow pointers
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
        	return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
        	if (fast == slow) {
        		return true;
        	}
        	slow = slow.next;
        	fast = fast.next.next;

        }
        return false;
    }

    /**
	 * Version 2: Use HashSet to contain all passed nodes
	 *      Time: O(n)
	 *     Space: O(n)
	 */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
        	return false;
        }

        HashSet<ListNode> set = HashSet<ListNode>();
        while (head != null) {
        	if (set.contains(head)) {
        		return true;
        	} else {
        		set.add(head);
        	}

        	head = head.next;
        }

        return false
    }
}