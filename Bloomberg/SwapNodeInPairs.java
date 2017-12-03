/**
 *	24. Swap Nodes in Pairs
 *	https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
class SwapNodeInPairs {

	/**
	 * Version 1: Use three pointers to traverse the LinkedList
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode start = dummy;
        ListNode mid = head;
        ListNode end = head.next;
        
        while (end != null) {
            start.next = end;
            mid.next = end.next;
            end.next = mid;
            
            if (mid.next == null || mid.next.next == null) {
                return dummy.next;
            }
            start = mid;
            mid = mid.next;
            end = mid.next;
        }
        
        return dummy.next;
    }
}