/**
 *	419. Battleships in a Board
 *	https://leetcode.com/problems/battleships-in-a-board/description/
 */
class BattleshipsInBoard {

	/**
	 * Version 1: Traverse from right-lower side(left-upper also works) of the map;
	 *            Increment the counter only when its right and lower doesn't marked as 'X'
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = board[0].length - 1; j >= 0; j--) {
                boolean flag = false;
                // check horizontal direction
                if ((j == board[0].length - 1 || board[i][j + 1] != 'X') && board[i][j] == 'X') {
                    flag = flag || true;
                }
                
                // check vertical direction
                if ((i == board.length - 1 || board[i + 1][j] != 'X') && board[i][j] == 'X') {
                    flag = flag && true;
                } else {
                    flag = flag && false;
                }
                
                if (flag) { count++; }
            }
        }
        
        return count;
    }
}