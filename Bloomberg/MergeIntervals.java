/**
 *	56. Merge Intervals
 *	https://leetcode.com/problems/merge-intervals/description/
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class MergeIntervals {

	/**
	 * Version 1: Sort intervals by start, then merge intervals one by one
	 *      Time: O(nlogn) -> sort intervals using O(nlogn)
	 *     Space: O(1)
	 */
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() < 2) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		List<Interval> result = new ArrayList<Interval>();
		Interval last = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (last.end >= curr.start) {
				last.end = Math.max(curr.end, last.end);
			} else {
				result.add(last);
				last = curr;
			}
		}

		result.add(last);
		return result;
	}
}