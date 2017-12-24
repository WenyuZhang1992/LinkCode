/**
 *	133. Clone Graph
 *	https://leetcode.com/problems/clone-graph/description/
 */
class CloneGraph {

	/**
	 * Version 1: Use BFS 
     *            Use HashMap to map new nodes to old nodes and keep records of traversed nodes
	 *      Time: O(V + E) -> each vertices will be visited once and each edge will be visited twice
	 *     Space: O(V)
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        UndirectedGraphNode startNode = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        queue.add(node);
        map.put(node, startNode);

        while (queue.size() != 0) {
            UndirectedGraphNode oldNode = queue.poll();

            for (UndirectedGraphNode neighbor : oldNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNeighbor);
                    queue.add(neighbor);
                }
                map.get(oldNode).neighbors.add(map.get(neighbor));
            }
        }

        return startNode;
    }

    /**
     * Version 2: Use DFS 
     *      Time: O(V + E) -> each vertices will be visited once and each edge will be visited twice
     *     Space: O(V)
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        return clone(node, map);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            newNode.add(neighbor, map);
        }

        return newNode;
    }
}