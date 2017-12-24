/**
 *	240. Search a 2D Matrix II
 *	https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
class Search2DMatrixII {

	/**
	 * Version 1: Start traversing from Top-Right corner
	 *      Time: O(m + n)
	 *     Space: O(1)
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = 0;
        int col = matrix[0].length - 1;
        
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                --col;
            } else {
                ++row;
            }
        }
        return false;
    }
}