/**
 *	57. Insert Interval
 *	https://leetcode.com/problems/insert-interval/description/
 */
class InsertInterval {

	/**
	 * Version 1: Firstly insert interval to correct position;
     *            Then perform merging to the intervals;
	 *      Time: O(2n)
	 *     Space: O(n)
	 */
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        if (newInterval.start >= intervals.get(intervals.size() - 1).start) {
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

    private List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }

        List<Interval> result = new ArrayList();
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

    /**
     * Version 1: There are three situations for a interval curr in the list and the newInterval:
     *            1. curr is totally on left of the newInterval -> directly add curr into result list;
     *            2. curr is totally on the right of the newInterval -> add newInterval and the rest of list sequentially;
     *            3. There is overlap between curr and newInterval -> merge the interval to construct newInterval;
     *      Time: O(n) -> Only one pass
     *     Space: O(1)
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        boolean flag = false;
        for (int i = 0; i < intervals.size(); ++i) {
            Interval curr = intervals.get(i);
            if (curr.end < newInterval.start) {
                // curr is totally on left of newInterval
                result.add(curr);
            } else if (curr.start > newInterval.end) {
                // curr is totally on right of newInterval
                result.add(newInterval);
                flag = true;
                for (int j = i; j < intervals.size(); ++j) {
                    result.add(intervals.get(j));
                }
                break;
            } else {
                // Overlap between curr and newInterval
                newInterval = new Interval(Math.min(curr.start, newInterval.start), Math.max(curr.end, newInterval.end));
            }
        }

        if (!flag) {
            result.add(newInterval);
        }

        return result;
    }
}