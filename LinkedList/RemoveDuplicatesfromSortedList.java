import java.util.*;

/**
 * Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 */
public class RemoveDuplicatesfromSortedList {

    /**
     * Version 1: Use two pointers
     *      Time: O(n)
     *     Space: O(1)
     */
    public static ListNode deleteDuplicates(ListNode head) {
    	if (head == null)
    		return null;

    	ListNode dummy = new ListNode(0);
    	dummy.next = head;

    	ListNode prev = head;
    	ListNode curr = prev.next;

    	while (curr != null) {
    		if (prev.val == curr.val) {
    		    curr = curr.next;
    		} else {
    		    prev.next = curr;
    		    prev = curr;
    		    curr = curr.next;
    		}
    	}
    	prev.next = curr;
    }

    /**
     * Version 2: Use only one pointer
     *      Time: O(n)
     *     Space: O(1)
     */
    public static ListNode deleteDuplicatesOnePointer(ListNode head) {
    	if (head == null)
    		return null;

    	ListNode temp = head;
    	while (temp.next != null) {
    		if (temp.val == temp.next.val) {
    			temp.next = temp.next.next;
    		}
    		temp = temp.next;
    	}
    	return head;
    }
}