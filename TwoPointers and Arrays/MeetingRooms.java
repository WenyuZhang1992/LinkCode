/**
 *	252. Meeting Rooms
 *	Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 *  determine if a person could attend all meetings.
 *
 *  Example: Given [[0, 30],[5, 10],[15, 20]],
 *           Return false.
 */
class MeetingRooms {

	public class Interval {
        int start; 
        int end; 
        Interval() { start = 0; end = 0; } 
        Interval(int s, int e) { start = s; end = e; } 
    } 

	/**
	 * Version 1: Sort the intervals on start time, check if the start time is larger than previous' end time
	 *      Time: O(nlogn)
	 *     Space: O(1)
	 */
	public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) {
            return true;
        }

        Arrays.sort(intervals, new IntervalComparator());

        for (int i=1; i < intervals.length; i++) {
            Interval curr = intervals[i];
            Interval last = intervals[i-1];
            if (curr.start < last.end) {
                return false;
            }
        }

        return true;
    }

    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
}