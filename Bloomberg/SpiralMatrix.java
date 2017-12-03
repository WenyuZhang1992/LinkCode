/**
 *  54. Spiral Matrix
 *  https://leetcode.com/problems/spiral-matrix/description/
 */
class SpiralMatrix {

    /**
     * Version 1: Use recursion, we can see that spiral can divided into two pattern:
     *            Right and down; left and up
     *            Use recursion and pass in two nodes of the rectangular as well as the pattern flag
     *      Time: O(m*n)
     *     Space: O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        helper(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, true, result);
        return result;
    }
    
    private void helper(int[][] map, int i1, int j1, int i2, int j2, boolean flag, List<Integer> result) {
        
        if (flag) {
            // add horizontal elements
            for (int j = j1; j <= j2; j++) {
                result.add(map[i1][j]);
            }
            // add vertical elements
            for (int i = i1 + 1; i <= i2; i++) {
                result.add(map[i][j2]);
            }
            if (i1 != i2 && j1 != j2) {
                helper(map, i1 + 1, j1, i2, j2 - 1, false, result);
            }
            return;
        } else {
            // add horizontal elements
            for (int j = j2; j >= j1; j--) {
                result.add(map[i2][j]);
            }
            // add vertical elements
            for (int i = i2 - 1; i >= i1; i--) {
                result.add(map[i][j1]);
            }
            if (i1 != i2 && j1 != j2) {
                helper(map, i1, j1 + 1, i2 - 1, j2, true, result);

            }
        }
    }
}