/**
 *	382. Linked List Random Node
 *	https://leetcode.com/problems/linked-list-random-node/description/
 */

/** Version 1: Use Reservoir Sampling to maintain a reservoir with size of 1
 *       Time: O(n)
 *      Space: O(1)
 */
class LinkedListRandomNode {

    private ListNode head;
    private Random random;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int result = head.val;
        int i = 2;
        ListNode curr = head.next;

        while (curr != null) {
            if (random.nextInt(i) == 0) {
                result = curr.val;
            }
            ++i;
            curr = curr.next;
        }
        return result;
    }
}