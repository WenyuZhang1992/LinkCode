/**
 *	729. My Calendar I
 *	https://leetcode.com/problems/my-calendar-i/description/
 */

/** Version 1: Store all the intervals, every time book() is called check if overlapping occurs:
 *             Overlapping occurs when: curr.start < newInterval.end && curr.end > newInterval.start
 *       Time: O(n)
 *      Space: O(n)
 */
class MyCalendarI {
    
    List<int[]> intervals;
    public MyCalendar() {
        intervals = new LinkedList<int[]>();
    }
    
    public boolean book(int start, int end) {
        for (int[] interval : intervals) {
            if (interval[1] > start && interval[0] < end) {
                return false;
            }
        }
        
        intervals.add(new int[] {start, end});
        return true;
    }
}

/** Version 2: Use TreeMap to store <start, end> pair;
 *             Every time call book(), ckeck its floor entry and ceiling entry to see if there's overlap;
 *       Time: O(logn)
 *      Space: O(n)
 */
class MyCalendar {
    
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if (prev != null && map.get(prev) > start) {
            return false;
        }
        if (next != null && next.intValue() < end) {
            return false;
        }

        map.put(start, end);
        return true;
    }
}