/**
 *	138. Copy List with Random Pointer
 *	https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */
class CopyListWithRandomPointer {

	/**
	 * Version 1: Use a HashMap to keep <OldNode, NewNode> pair;
     *            Traverse list twice: First time construct the new list by next reference and fill map;
     *                                 Second time assign random reference by fetching from map;
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap();

        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);

        RandomListNode curr = head.next;
        RandomListNode tail = newHead;
        while (curr != null) {
            RandomListNode temp = new RandomListNode(curr.label);
            tail.next = temp;
            map.put(curr, temp);
            
            tail = tail.next;
            curr = curr.next;
        }
        
        curr = head;
        tail = newHead;
        while (curr != null) {
            tail.random = map.get(curr.random);
            tail = tail.next;
            curr = curr.next;
        }
        
        return newHead;
    }
}