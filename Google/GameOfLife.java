/**
 *	289. Game of Life
 *	https://leetcode.com/problems/game-of-life/description/
 */
class GameOfLife {

	/**
	 * Version 1: Use the decimal digit to represent next state
     *            Use the smaller digit to represent current stat
	 *      Time: O(m*n)
	 *     Space: O(1)
	 */
	public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = countLive(board, i, j);
                int dead = 8 - live;
                if (board[i][j] % 10 == 1) {
                    if (live == 2 || live == 3) {
                        board[i][j] = 10 + board[i][j];
                    }
                } else {
                    if (live == 3) {
                        board[i][j] = 10 + board[i][j];
                    }
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] / 10;
            }
        }
    }
    
    private int countLive(int[][] board, int i, int j) {
        int result = 0;
        int[] xIndex = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] yIndex = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int index = 0; index < xIndex.length; index++) {
            int x = i + xIndex[index];
            int y = j + yIndex[index];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] % 10 == 1) {
                ++result;
            }
        }
        return result;
        
    }
}