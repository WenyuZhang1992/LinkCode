/**
 *  146. LRU Cache
 *  https://leetcode.com/problems/lru-cache/description/
 */

/** Version 1: Use a Doubly Linked List and a Map
 *       Time: O(1)
 *      Space: O(n)
 */
class DLNode {
    int key;
    int value;
    DLNode prev;
    DLNode next;

    public DLNode(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}

class LRUCache {

    private int capacity;
    private DLNode head;
    private DLNode tail;
    HashMap<Integer, DLNode> map;

    // tail -> most recently referred
    // head -> least recently referred
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLNode(-1, -1);
        tail = new DLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, DLNode>();
    }
    
    // if not exists, return -1
    // otherwise, return the value, update the DLList
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        DLNode temp = map.get(key);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        moveToTail(temp);
        return temp.value;
    }
    
    // if exists, update
    // if have space, add to end of DLList
    // if no space, remove from head
    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if (map.size() >= capacity) {
            DLNode remove = head.next;

            head.next = remove.next;
            remove.next.prev = head;

            map.remove(remove.key);
        } 

        DLNode newNode = new DLNode(key, value);
        moveToTail(newNode);
        map.put(key, newNode);
    }

    private void moveToTail(DLNode node) {

        // Add into tail of list
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}