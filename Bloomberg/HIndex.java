/**
 *	274. H-Index
 *	https://leetcode.com/problems/h-index/description/
 */
class HIndex {

	/**
	 * Version 1: Sort the array
	 *      Time: O(nlogn)
	 *     Space: O(1)
	 */
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return -1;
		}

		Arrays.sort(citations);
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < citations.length; i++) {
			int temp = Math.min(citation.length - i, citations[i]);
			result = Math.max(result, temp);
		}

		return result;
	}

	/**
	 * Version 2: Use HashTable
	 *      Time: O(nlogn)
	 *     Space: O(1)
	 */
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return -1;
		}

		int[] cnt = new int[]
	}
}