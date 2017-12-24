/**
 *  684. Redundant Connection
 *  https://leetcode.com/problems/redundant-connection/description/
 */

class RedundantConnection {

    /**
     * Version 1: Use Union-Find
     *      Time: O(n^2) -> Look for element ID at most takes O(n)
     *     Space: O(n)
     */
    int[] id = new int[1001];
    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

        for (int[] edge : edges) {
            int x = find(edge[0]);
            int y = find(edge[1]);

            if (union(x, y)) {
                return edge;
            }
        }
        return new int[0];
    }

    private int find(int element) {
        if (id[element] == element) {
            return element;
        }
        return find(id[element]);
    }

    private boolean union(int x, int y) {
        if (find(x) == find(y)) {
            return true;
        }
        id[x] = y;
        return false;
    }
}

