/**
 *  Marathon Ranker:
 *  Given some runners with ID and name, some markers along the track with ID and distance to the end point.
 *  Every marker can detect the runner passing it;
 *  Implementa data structures and methods to get Top K runners;
 */

/** Version 1: Use Doubly Linked List and HashMap;
 *             Maintain one doubly linked list contains all markers already passed;
 *             Each marker contains a list of runners passing it;
 *       Time: O(k)
 *      Space: O(m + n) -> m is the number of runners, n is the number of markers
 */
class RunnerNode {
    int id;
    RunnerNode prev;
    RunnerNode next;

    MarkerNode cp;

    public RunnerNode(int id) {
        this.id = id;

        prev = null;
        next = null;
        cp = null;
    }
}

class MarkerNode {
    int id;

    MarkerNode prev;
    MarkerNode next;

    // head -> early pass
    // tail -> slow pass
    RunnerNode head;
    RunnerNode tail;

    public MarkerNode(int id) {
        this.id = id;

        prev = null;
        next = null;

        head = new RunnerNode(-1);
        head.cp = this;
        tail = new RunnerNode(-1);
        tail.cp = this;

        head.next = tail;
        tail.prev = head;
    }

    public void addToTail(RunnerNode node) {
        RunnerNode rPrev = tail.prev;
        rPrev.next = node;
        node.prev = rPrev;
        node.next = tail;
        tail.prev = node;

        node.cp = this;
    }
}

class MarathonRanker {

    HashMap<Integer, RunnerNode> runnerMap;
    HashMap<Integer, MarkerNode> markerMap;

    // Head -> far from end point
    // tail -> close to end point
    MarkerNode head;
    MarkerNode tail;

    int lastMarker;

    public MarathonRanker() {
        runnerMap = new HashMap<>();

        markerMap = new HashMap<>();
        // Feed markerMap

        head = new MarkerNode(-1);
        tail = new MarkerNode(-1);

        head.next = tail;
        tail.prev = head;

        lastMarker = 0;
    }

    public void update(int runnerID, int cpID) {
        // If runner not in runnerMap
        if (!runnerMap.containsKey(runnerID)) {
            RunnerNode newNode = new RunnerNode(runnerID);
            runnerMap.put(runnerID, newNode);
        }

        RunnerNode runner = runnerMap.get(runnerID);
        // Runner passed marker before
        // Need to remove runner from previous marker list
        if (runner.cp != null) {
            RunnerNode rPrev = runner.prev;
            RunnerNode rNext = runner.next;

            rPrev.next = rNext;
            rNext.prev = rPrev;
        }

        if (!markerMap.containsKey(cpID)) {
            MarkerNode newNode = new MarkerNode(cpID);
            MarkerNode prev = tail.prev;
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = tail;
            tail.prev = newNode;

            markerMap.put(cpID, newNode);
        }

        MarkerNode mNode = markerMap.get(cpID);
        mNode.addToTail(runner);
        lastMarker = Math.max(cpID, lastMarker);
    }

    public void getTopK(int k) {
        MarkerNode mNode = markerMap.get(lastMarker);
        RunnerNode rNode = mNode.head.next;
        while (true) {
            while (rNode != mNode.tail) {
                System.out.println(rNode.id);
                if (--k == 0) { return; }
                rNode = rNode.next;
            }
            mNode = rNode.cp.prev;
            rNode = mNode.head.next;
        }
    }
}