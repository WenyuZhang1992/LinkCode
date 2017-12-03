/**
 *	79. Word Search
 *	https://leetcode.com/problems/word-search/description/
 */
class WordSearch {
	
	/**
	 * Version 1: Use BFS
	 *      Time: O(m^2*n^2)
	 *     Space: O(1)
	 */
	public boolean exist(char[][] board, String word) {
        
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, String word, int i, int j, int l) {
        if (l == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(l)) {
            return false;
        }
        
        // Mark off current position so can't use it anymore
        board[i][j] = '#';
        
        boolean result = helper(board, word, i+1, j, l + 1) || helper(board, word, i-1, j, l + 1) || 
            helper(board, word, i, j-1, l + 1) || helper(board, word, i, j+1, l + 1);
        
        // Recover the element
        board[i][j] = word.charAt(l);
        
        return result;
    }
}