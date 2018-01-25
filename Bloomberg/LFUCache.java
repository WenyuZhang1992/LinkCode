/**
 *	460. LFU Cache
 *	https://leetcode.com/problems/lfu-cache/description/
 */

/** Version 1: Use a HashMap to keep <Key, Node> pair;
 *             Create a NodeList data structure, which contains all Node with same frequency, head of the list represents the LRU node;
 *             LFU cache contains a list of NodeList, head of the list represents the lowest frequency; 
 *       Time: O(1)
 *      Space: O(n)
 */
class Node {
    int key;
    int value;
    int freq;
    Node prev;
    Node next;
    NodeList nl;

    public Node(int key, int value) {
        prev = null;
        next = null;
        this.key = key;
        this.value = value;
        freq = 0;
    }
}

class NodeList {
    NodeList next;
    NodeList prev;

    int freq;
    int size;

    Node head;
    Node tail;

    public NodeList(int freq) {
        this.freq = freq;
        this.size = 0;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void insertNode(Node node) {
        node.nl = this;
        Node prevNode = tail.prev;
        node.prev = prevNode;
        node.next = tail;
        prevNode.next = node;
        tail.prev = node;
        size++;
    }
}

class LFUCache {

    HashMap<Integer, Node> map;
    int capacity;
    NodeList head;
    NodeList tail;

    public LFUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;

        head = new NodeList(-1);
        tail = new NodeList(-1);

        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        updateNode(node);

        return node.value;
    }

    private void updateNode(Node node) {
        node.freq = node.freq + 1;

        if (node.nl.next != this.tail && node.nl.next.freq == node.freq) {
            // If next list has the same frequency with the node
            removeNode(node);

            // Insert node into next NodeList's tail
            NodeList currList = node.nl.next;
            currList.insertNode(node);
        } else {
            // Need to insert a new NodeList
            NodeList newList = new NodeList(node.freq);
            NodeList prevList = node.nl;
            NodeList nextList = node.nl.next;
            newList.prev = prevList;
            newList.next = nextList;
            prevList.next = newList;
            nextList.prev = newList;

            // Insert the node to the tail of this new NodeList
            removeNode(node);
            newList.insertNode(node);
        }
    }

    private Node removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        if (node.nl.size - 1 <= 0) {
            removeList(node.nl);
        }
        node.nl.size--;
        return node;
    }

    private void removeList(NodeList nl) {
        nl.prev.next = nl.next;
        nl.next.prev = nl.prev;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if (map.size() == capacity) {
            Node toRemove =removeNode(head.next.head.next);
            map.remove(toRemove.key);
        }

        Node newNode = new Node(key, value);
        if (head.next == tail) {
            // Contains no NodeList, insert a new one
            NodeList newList = new NodeList(newNode.freq);
            newList.prev = head;
            newList.next = tail;
            head.next = newList;
            tail.prev = newList;

            newList.insertNode(newNode);
        } else if (head.next.freq != newNode.freq) {
            // Need to insert a new NodeList
            NodeList newList = new NodeList(newNode.freq);
            NodeList nextList = head.next;
            newList.prev = head;
            newList.next = nextList;
            head.next = newList;
            nextList.prev = newList;

            newList.insertNode(newNode);
        } else {
            // head.next is the NodeList we need to insert the node
            head.next.insertNode(newNode);
        }

        map.put(key, newNode);
    }
}