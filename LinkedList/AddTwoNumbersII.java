/**
 *	445. Add Two Numbers II
 *	https://leetcode.com/problems/add-two-numbers-ii/description/
 */
class AddTwoNumbersII {

	/**
	 * Version 1: Reverse the Linked Lists, then add by digits and reverse the resultant Linked List
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
        
        ListNode t1 = reverse(l1);
        ListNode t2 = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        int carry = 0;
        while (t1 != null && t2 != null) {
            int sum = carry + t1.val + t2.val;
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;
            t1 = t1.next;
            t2 = t2.next;
            tail = tail.next;
        }
        
        while (t1 != null) {
            int sum = carry + t1.val;
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;
            t1 = t1.next;
            tail = tail.next;
        }
        
        while (t2 != null) {
            int sum = carry + t2.val;
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;
            t2 = t2.next;
            tail = tail.next;
        }
        
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        
        return reverse(dummy.next);
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