/**
 *	79. Word Search
 *	https://leetcode.com/problems/word-search/description/
 */
class WordSearch {

	/**
	 * Version 1: Use DFS
	 *      Time: O(m*n*4^k)
	 *     Space: O(k) -> length of word since at most k stacks will exist
	 */
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && search(board, i, j, word, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean search(char[][] board, int i, int j, String word, int index) {
		if (index == word.length()) {
			return true;
		}
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
			return false;
		}

		board[i][j] = '&';
		boolean result = search(board, i + 1, j, word, index + 1) || search(board, i - 1, j, word, index + 1) ||
							search(board, i, j + 1, word, index + 1) || search(board, i, j - 1, word, index + 1);
		board[i][j] = word.charAt(index);
		return result;
	}
}