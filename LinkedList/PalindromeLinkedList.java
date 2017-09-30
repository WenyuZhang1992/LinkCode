/**
 *	234. Palindrome Linked List
 *	https://leetcode.com/problems/palindrome-linked-list/description/
 */
class PalindromeLinkedList {
	
	/**
	 * Version 1: Use fast-slow pointers to find the middle node,
     *            Reverse the list from the middle node
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode middle = findMiddle(head);
        
        middle.next = reverse(middle.next);
        
        ListNode p1 = head;
        ListNode p2 = middle.next;
        
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
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