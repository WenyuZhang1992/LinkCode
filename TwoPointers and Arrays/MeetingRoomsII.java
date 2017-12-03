/**
 *	253. Meeting Rooms II
 *	Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 *  find the minimum number of conference rooms required.
 *
 *  Example: [[0, 30],[5, 10],[15, 20]] 
 *           return 2
 */
class MeetingRoomsII {

	public class Interval {
        int start; 
        int end; 
        Interval() { start = 0; end = 0; } 
        Interval(int s, int e) { start = s; end = e; } 
    } 

	/**
	 * Version 1: Sort the intervals by start time then use a minHeap to keep end time
     *            if my current interval's start time < minHeap.peek() -> means we need a new room
     *            else remove the min end time because this room will be taken till the current interval's end time
	 *      Time: O(nlogn) -> O(logn) for minHeap operation, need to operate O(n) times
	 *     Space: O(1)
	 */
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

	public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new IntervalComparator());
        Queue<Integer> minHeap = new PriorityQueue<Integer>();

        int count;
        for (int i = 0; i < intervals.length; i++) {
            minHeap.add(intervals[i].end);
            if (intervals[i].start < minHeap.peek()) {
                count++;
            } else {
                minHeap.poll();
            }
        }

        return count;
    }

    /**
     * Version 2: 
     *      Time: O(nlogn) -> O(logn) for minHeap operation, need to operate O(n) times
     *     Space: O(1)
     */
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        
    }
}