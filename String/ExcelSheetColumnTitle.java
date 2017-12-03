/**
 *	168. Excel Sheet Column Title
 *	https://leetcode.com/problems/excel-sheet-column-title/discuss/
 */
class ExcelSheetColumnTitle {
	
	/**
	 * Version 1: Corner case when handle 26 -> decrement n first!
     *            Remember to reverse the character sequence
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remind = --n % 26;
            sb.append((char)('A' + remind));
            n /= 26;
        }
        
        return sb.reverse().toString();
    }
}