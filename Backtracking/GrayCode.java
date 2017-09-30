/**
 *	89. Gray Code
 *	https://leetcode.com/problems/gray-code/description/
 */
class GrayCode {

	/**
	 * Version 1: graycode of n bits ==> graycode of (n-1) bits and 1 << (n-1) + reversed graycode of (n-1) bits
     *            Example: n = 2       00   01   10  11
     *                                 0    1    3   2
     *                     n = 3
     *                                 000  001  010  011 111 110 101 100
     *                                 0    1    3    2   6   7   5   4
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<Integer>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        
        List<Integer> preResult = grayCode(n-1);
        result.addAll(preResult);
        
        int addNumber = 1 << (n-1);
        for (int i : preResult) {
            int temp = i + addNumber;
            result.add(preResult.size(), temp);
        }
        
        return result;
    }
}