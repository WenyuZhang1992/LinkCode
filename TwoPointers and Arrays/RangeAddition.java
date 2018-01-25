/**
 *	370. Range Addition
 *	Assume you have an array of length n initialized with all 0's and are given k update operations.
 *  Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 *  Return the modified array after all k operations were executed.
 *
 *  Example:
 *
 *  Given:
 *  length = 5,
 *  updates = [
 *      [1,  3,  2],
 *      [2,  4,  3],
 *      [0,  2, -2]
 *  ]
 *
 *  Output:
 *
 *   [-2, 0, 3, 5, 3]
 */
class RangeAddition {

	/**
	 * Version 1: For every updates, we only need to increment element at startIndex by inc 
     *            and decrement element at (endIndex + 1) by inc;
     *            Calculate cumulative sum ending at every index as final modified array;
     *            This approach makes sence since acumulative sum will add inc starting from startIndex and delete inc after endIndex;
	 *      Time: O(k + n) -> k is the number of updates, n is value of parameter length
	 *     Space: O(1)
	 */
	public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            result[start] += update[2];

            // It's possible to update till end of array
            // In this case, we don't need to add decrement anymore since cumulative sum won't reach the decrement position
            if (end < length - 1) {
                result[end + 1] -= update[2];
            }
        }

        for (int i = 1; i < result.length; ++i) {
            result[i] = result[i - 1] + result[i];
        }

        for (int i : result) {
            System.out.println(i);
        }
        return result;
    }
}