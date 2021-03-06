/**
 *	445. Add Two Numbers II
 *	https://leetcode.com/problems/add-two-numbers-ii/description/
 */
class AddTwoNumbersII {

	/**
	 * Version 1: Reverse the Linked Lists, then add by digits
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
        ListNode head = null;
        
        int carry = 0;
        while (t1 != null && t2 != null) {
            int sum = carry + t1.val + t2.val;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
            carry = sum / 10;
            t1 = t1.next;
            t2 = t2.next;
        }
        
        while (t1 != null) {
            int sum = carry + t1.val;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
            carry = sum / 10;
            t1 = t1.next;
        }
        
        while (t2 != null) {
            int sum = carry + t2.val;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
            carry = sum / 10;
            t2 = t2.next;
        }
        
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }
        
        return head;
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