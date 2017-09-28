import java.util.*;

/**
 *
 * Number of Islands
 *
 * Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. 
 * If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 * Find the number of islands.
 *
 */

class NumberOfIslands {
	
	/**
	 * Version 1: Use DFS to mark all contigent 1 to 0
	 *      Time: O(mn)
	 *     Space: O(1)
	 */
	public int numIslands(boolean[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int count = 0;
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				if (grid[i][j] == true) {
					markZero(grid, i, j);
					count++;
				}
			}
		}

		return count;
	}

	private void markZero(boolean[][] grid, int i, int j) {
		if (i > grid.length || i < 0 || j < 0 || j > grid[0].length || grid[i][j] == false) {
			return;
		}

		grid[i][j] = true;
		markZero(grid, i - 1, j);
		markZero(grid, i + 1, j);
		markZero(grid, i, j + 1);
		markZero(grid, i, j - 1);
	}

	/**
	 * Version 2: Use BFS
	 *      Time: O(mn)
	 *     Space: O(1)
	 */
	public int numIslandsBFS(boolean[][] grid) {
		
	}
}