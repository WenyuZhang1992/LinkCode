/**
 *  Stocker Ranker:
 *  Given some stocks and their trading count. Get Top K stocks throughout the day.
 */

/** Version 1: Use Doubly Linked List and HashMap;
 *             Maintain a Doubly Linked List of size k;
 *       Time: O(k) -> O(k) for both update() and topK() operations
 *      Space: O(n + k) -> n is the total count of different stocks
 */
class StockNode {
    String name;
    int count;
    boolean inList;

    StockNode prev;
    StockNode next;

    public StockNode(String name, int count) {
        this.name = name;
        this.count = count;
        inList = false;

        prev = null;
        next = null;
    }
}

class StockRanker {

    HashMap<String, StockNode> map;

    // Head -> low on count
    // Tail -> high on count
    StockNode head;
    StockNode tail;

    int size;
    int capacity;

    public StockRanker(int k) {
        map = new HashMap<>();

        head = new StockNode("Head", -1);
        tail = new StockNode("Tail", -1);
        head.next = tail;
        tail.prev = head;

        size = 0;
        capacity = k;
    }

    public void update(String name, int count) {
        // If a new stock
        if (!map.containsKey(name)) {
            StockNode node = new StockNode(name, count);
            map.put(name, node);
        } else {
            // If a previously added stock
            int newCount = map.get(name).count + count;
            map.get(name).count = newCount;
        }

        StockNode node = map.get(name);

        // If the node is already in the list
        if (node.inList) {
            StockNode oldPrev = node.prev;
            StockNode oldNext = node.next;
            oldPrev.next = oldNext;
            oldNext.prev = oldPrev;

            node.prev = null;
            node.next = null;
            --size;
        }

        // Need to insert into list
        if (head.next.count < node.count) {
            StockNode temp = head.next;
            while (temp != tail && temp.count < node.count) {
                temp = temp.next;
            }

            StockNode newPrev = temp.prev;
            newPrev.next = node;
            temp.prev = node;
            node.prev = newPrev;
            node.next = temp;
            node.inList = true;
            ++size;

            // If need to remove a node from head
            if (size > capacity) {
                StockNode newFirst = head.next.next;
                StockNode oldFirst = head.next;

                head.next = newFirst;
                newFirst.prev = head;

                oldFirst.prev = null;
                oldFirst.next = null;
                oldFirst.inList = false;
                --size;
            }
        }
    }

    public void topK() {
        int count = Math.min(size, capacity);

        StockNode temp = tail.prev;
        while (temp != head && count > 0) {
            System.out.println(temp.name);
            temp = temp.prev;
            --count;
        }
    }

/** Version 2: Use TreeSet and HashMap;
 *             Maintain a TreeSet of size k, actually TreeSet is implemented by BST;
 *       Time: O(logk) -> O(logk) for both update() and topK() operations
 *      Space: O(n + k) -> n is the total count of different stocks
 */
class StockNode {
    String name;
    int count;
    boolean inSet;

    StockNode prev;
    StockNode next;

    public StockNode(String name, int count) {
        this.name = name;
        this.count = count;
        inSet = false;

        prev = null;
        next = null;
    }
}

class StockRanker {

    HashMap<String, StockNode> map;
    TreeSet<StockNode> set;

    int capacity;

    public StockRanker(int k) {
        map = new HashMap<>();
        set = new TreeSet<StockNode>(new Comparator<StockNode>() {
            @Override
            public int compare(StockNode s1, StockNode s2) {
                return s1.count - s2.count;
            }
        });

        this.capacity = k;
    }

    public void update(String name, int count) {
        if (!map.containsKey(name)) {
            StockNode node = new StockNode(name, count);
            map.put(name, node);
        } else {
            map.get(name).count = map.get(name).count + count;
        }

        // If the node is in set
        StockNode node = map.get(name);
        if (node.inSet) {
            set.remove(node);
            node.inSet = false;
        }

        if (set.size() < capacity || set.lower(node) != null) {
            set.add(node);
            node.inSet = true;
            if (set.size() > capacity) {
                StockNode temp = set.pollFirst();
                temp.inSet = false;
            }
        }
    }

    public String[] topK() {
        String[] result = new String[Math.min(capacity, set.size())];
        Iterator<StockNode> iter = set.iterator();
        int index = result.length - 1;
        while (iter.hasNext()) {
            result[index--] = iter.next().name;
        }
        return result;
    }
}