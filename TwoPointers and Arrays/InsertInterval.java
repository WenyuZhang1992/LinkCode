/**
 *	57. Insert Interval
 *	https://leetcode.com/problems/insert-interval/description/
 */
class InsertInterval {

	/**
	 * Version 1: Use decreasing stack which stores only index
     *            Everytime getting a larger element, calculate the water amount using continuous three heights 
	 *      Time: O(n) -> every index only being pushed and popped once respectively
	 *     Space: O(n)
	 */
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        if (newInterval.start > intervals.get(intervals.size() - 1).start) {
            intervals.add(newInterval);
        } else {
            for (int i = 0; i < intervals.size(); ++i) {
                if (intervals.get(i).start > newInterval.start) {
                    intervals.add(i, newInterval);
                    break;
                }
            }
        }

        return mergeIntervals(intervals);
    }

    private List<Intervals> mergeIntervals(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }

        List<Intervals> result = new ArrayList();
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); ++i) {
            if (last.end >= intervals.get(i).start) {
                last.start = Math.min(last.start, intervals.get(i).start);
                last.end = Math.max(last.end, intervals.get(i).end);
            } else {
                result.add(last);
                last = intervals.get(i);
            }
        }
        result.add(last);
        
        return result;
    }
}