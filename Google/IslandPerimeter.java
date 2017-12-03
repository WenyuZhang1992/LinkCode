/**
 *	463. Island Perimeter
 *	https://leetcode.com/problems/island-perimeter/description/
 */
class IslandPerimeter {

	/**
	 * Version 1: Traverse the graph
	 *      Time: O(m*n)
	 *     Space: O(1)
	 */
	public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) { continue; }
                if (i - 1 < 0 || grid[i-1][j] == 0) { ++result; }
                if (i + 1 >= grid.length || grid[i+1][j] == 0) { ++result; }
                if (j - 1 < 0 || grid[i][j-1] == 0) { ++result; }
                if (j + 1 >= grid[0].length || grid[i][j+1] == 0) { ++result; }
            }
        }
        
        return result;
    }
}