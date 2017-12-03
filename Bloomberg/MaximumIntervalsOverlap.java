/**
 *	Find the point where maximum intervals overlap
 *	Consider a big party where a log register for guest’s entry and exit times is maintained. 
 *  Find the time at which there are maximum guests in the party. 
 *  Note that entries in register are not in any order.
 */
class MaximumIntervalsOverlap {

	/**
	 * Version 1: Sort the start and end array respectively
	 *			  Count the arrived and depart people and calculate the difference
	 *      Time: O(nlogn)
	 *     Space: O(1)
	 */
	public int findMaxOverlap(int[] start, int[] end, int time) {
		Arrays.sort(start);
		Arrays.sort(end);

		int startCount = 0;
		int endCount = 0;
		for (int i : start) {
			if (i <= time) {
				++startCount;
			}
		}

		for (int i : end) {
			if (i <= time) {
				++endCount;
			}
		}

		return startCount - endCount;
	}
}