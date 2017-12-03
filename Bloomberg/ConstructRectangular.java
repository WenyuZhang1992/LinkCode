/**
 *	Construct Rectangular using Input Nodes
 *	Given a set of nodes in x-y coordinate, output the rectangulars which can be constructed by these nodes
 *  Only consider the ones which are parallel to x and y axis
 */
class ConstructRectangular {

	/**
	 * Version 1: Use Min Heap to store only K elements
	 *      Time: O(nlogk)
	 *     Space: O(k)
	 */
	class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	class Rectangular {
		Node tl;
		Node tr;
		Node ll;
		Node lr;

		public Rectangular(Node tl, Node tr, Node ll, Node lr) {
			this.tl = tl;
			this.tr = tr;
			this.ll = ll;
			this.lr = lr;
		}
	}

	public List<Rectangular> constructRectangular(List<Node> nodes) {
		if (nodes == null || nodes.length < 4) {
			return new ArrayList<Rectangular>();
		}

		List<Rectangular> result = new ArrayList<Rectangular>();
		
	}
}