import java.util.*;

public class AddTwoNumbers {

	/**
 	 * Add Two Numbers
  	 *
 	 * You have two numbers represented by a linked list, 
 	 * where each node contains a single digit. 
 	 * The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
 	 * Write a function that adds the two numbers and returns the sum as a linked list.
 	 *
 	 *  Time: O(n)
     * Space: O(1)
     *
 	 */
	public ListNode addLists(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int carry = 0;

		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			tail.next = new ListNode(sum % 10);
			tail = tail.next;
			carry = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int sum = l1.val + carry;
			tail.next = new ListNode(sum % 10);
			tail = tail.next;
			carry = sum / 10;
			l1 = l1.next;
		}

		while (l2 != null) {
			int sum = l2.val + carry;
			tail.next = new ListNode(sum % 10);
			tail = tail.next;
			carry = sum / 10;
			l2 = l2.next;
		}

		if (carry > 0) {
			tail.next = new ListNode(carry);
		}

		return dummy.next;
	}

	/**
 	 * Add Two Numbers II
  	 *
 	 * You have two numbers represented by a linked list, 
 	 * where each node contains a single digit. 
 	 * The digits are stored in forward order, such that the 1's digit is at the head of the list. 
 	 * Write a function that adds the two numbers and returns the sum as a linked list.
 	 *
 	 *  Time: O(n)
     * Space: O(1)
     *
 	 */
	public ListNode addLists2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while (l1 != null) {
        	s1.push(l1.val);
        	l1 = l1.next;
        }

        while (l2 != null) {
        	s1.push(l2.val);
        	l1 = l2.next;
        }

        ListNode head = null;
        int carry = 0;

        while (s1.size() != 0 && s2.size() != 0) {
        	int sum = s1.pop() + s2.pop() + carry;
        	ListNode temp = new ListNode(sum % 10);
        	carry = sum / 10;
        	temp.next = head;
        	head = temp;
        }

        while (s1.size() != 0) {
        	int sum = s1.pop() + carry;
        	ListNode temp = new ListNode(sum % 10);
        	carry = sum / 10;
        	temp.next = head;
        	head = temp;
        }

        while (s2.size() != 0) {
        	int sum = s2.pop() + carry;
        	ListNode temp = new ListNode(sum % 10);
        	carry = sum / 10;
        	temp.next = head;
        	head = temp;
        }

        return head;
    }
}