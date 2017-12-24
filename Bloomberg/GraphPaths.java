/**
 *	Graph Paths:
 *	1. Given a start node and an end node in a directed graph, print all paths in the graph(including the paths not reaching end);
 *	2. Mark the paths that contains circle;
 *  3. Remove the paths not reaching end node and the circles in the graph;
 */
class GraphPaths {

	/**
	 * Version 1: Use DFS
	 *      Time:
	 *     Space:
	 */
	class Node {
		String name;
		List<Node> children;
	}

	// Part 1:
	public void prinPaths(Node start, Node end) {
		List<String> list = new ArrayList<String>();
		list.add(start.name);
		helper(start, end, list);
	}

	private void helper(Node start, Node end, List<String> list) {
		if (start == end) {
			print(list);
			return;
		}
		if (start.children.size() == 0) {
			print(list);
			return;
		}

		for (Node child : children) {
			list.add(child.name);
			helper(child, end, list);
			list.remove(list.size() - 1);
		}
	}

	// Part 2:
	public void prinPaths(Node start, Node end) {
		List<String> list = new ArrayList<String>();
		HashSet<Node> set = new HashSet<Node>();
		list.add(start.name);
		set.add(start);
		boolean flag = false;
		helper(start, end, list, set, flag);
	}

	private void helper(Node start, Node end, List<String> list, HashSet<Node> set, boolean flag) {
		if (start == end) {
			print(list, flag);
			return;
		}
		if (start.children.size() == 0) {
			print(list, flag);
			return;
		}

		for (Node child : children) {
			if (set.contains(child)) {
				flag = true;
			}
			list.add(child.name);
			set.add(child);
			helper(child, end, list, flag);
			list.remove(list.size() - 1);
			set.remove(child);
		}
	}
}