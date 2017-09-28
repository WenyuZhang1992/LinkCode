/**
  * Leetcode 120: Triangle
  * https://leetcode.com/problems/triangle/description/
  */
import java.util.*;

class Triangle {

	/**
	 * Version 1: Use DP with a 2D matrix to store min path end at this point
	 *      Time: O(n^2)
	 *     Space: O(n^2)
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        
        int M = triangle.size();
        int[][] path = new int[M][M];
        
        // Intialize
        path[0][0] = triangle.get(0).get(0);
        for (int i=1; i<M; i++) {
            path[i][0] = triangle.get(i).get(0) + path[i-1][0];
            path[i][i] = triangle.get(i).get(i) + path[i-1][i-1];
        }
        
        // Function
        for (int m = 2; m < M; m++) {
            for (int n=1; n < m; n++) {
                path[m][n] = triangle.get(m).get(n) + Math.min(path[m-1][n-1], path[m-1][n]);
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int j=0; j<M; j++) {
            result = Math.min(result, path[M - 1][j]);
        }
        return result;
	}
}
