import java.util.*;

/**
 * Remove Duplicates from Unsorted List
 *
 * Given a unsorted linked list, delete all duplicates such that each element appear only once.
 *
 */
public class RemoveDuplicatesfromUnsortedList {

	/**
     * Version 1: Use hash table to store the values
     *      Time: O(n)
     *     Space: O(n)
     */
    public static ListNode deleteDuplicates(ListNode head) {
    	if (head == null)
    		return null;

    	ListNode dummy = new ListNode(0);
    	dummy.next = head;

    	Set<Integer> set = new HashSet<Integer>();
    	set.add(head.val);

    	while (head.next != null) {
    		if (set.contains(head.next.val)) {
    			head.next = head.next.next;
    		} else {
    			set.add(head.next.val);
    		}
    		head = head.next;
    	}

    	return dummy.next;
    }

    /**
     * Version 2: Use two pointers
     *      Time: O(n^2)
     *     Space: O(1)
     */
    public static ListNode deleteDuplicatesTwoPointers(ListNode head) {
    	if (head == null)
    		return null;

    	ListNode dummy = new ListNode(0);
    	dummy.next = head;

    	ListNode curr = head.next;

    	while (curr != null) {
    		ListNode iter = dummy;
    		while (iter.next != curr) {
    			if (iter.next.val == curr.val) {
    				iter.next = iter.next.next;
    				break;
    			}
    			iter = iter.next;
    		}
    		curr = curr.next;
    	}
    	return dummy.next;
    }

    private static ListNode generateList(int[] n) {
    	ListNode dummy = new ListNode(0);
    	ListNode tail = dummy;
    	for (int i=0; i<n.length; i++) {
    		tail.next = new ListNode(n[i]);
    		tail = tail.next;
    	}
    	return dummy.next;
    }

    public static void main(String[] argv) {
    	// 12->11->12->21->41->43->21
    	int[] n = {12, 11, 12, 21, 41, 43, 21};
    	ListNode head = generateList(n);
    	ListNode newHead = deleteDuplicatesTwoPointers(head);
    	System.out.print("[ ");
    	while (newHead != null) {
    		System.out.print(newHead.val + " ");
    		newHead = newHead.next;
    	}
    	System.out.println("]");
    }
}