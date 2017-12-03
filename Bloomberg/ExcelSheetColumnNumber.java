/**
 *  171. Excel Sheet Column Number
 *  https://leetcode.com/problems/excel-sheet-column-number/description/
 */
class ExcelSheetColumnNumber {

    /**
     * Version 1: Traverse through the string
     *      Time: O(n)
     *     Space: O(1)
     */
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return Integer.MIN_VALUE;
        }
        
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = (s.charAt(i) - 'A') + 1;
            result = result * 26 + temp;
        }
        
        return result;
    }
}