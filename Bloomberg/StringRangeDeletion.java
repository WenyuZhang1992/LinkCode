/**
 *	Delete Ranges of String:
 *	Given a string and a list of ranges, delete the characters of the string baed on the ranges
 */
class StringRangeDeletion {

	/**
	 * Version 1: Need to merge the intervals first;
	 *			  Then, use StringBuilder to keep the characters not in the deleting ranges;
	 *      Time: O(mlogm + n) -> m is the length of Interval list, n is the length of the string
	 *     Space: O(m)
	 */
	public String deleteRange(String str, List<Interval> list) {
        if (str == null || str.length() == 0 || list.size() == 0) {
            return str;
        }

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        List<Interval> merged = new ArrayList();
        Interval last = new Interval(Math.max(list.get(0).start, 0), Math.min(str.length() - 1, list.get(0).end));
        for (int i = 1; i < list.size(); ++i) {
            Interval curr = new Interval(Math.max(list.get(i).start, 0), Math.min(str.length() - 1, list.get(i).end));
            if (curr.start < last.end) {
                last.start = Math.min(last.start, curr.start);
                last.end = Math.max(last.end, curr.end);
            } else {
                merged.add(last);
                last = curr;
            }
        }
        merged.add(last);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        Interval inter = merged.get(0);
        while (i < str.length()) {
            if (i < inter.start) {
                sb.append(str.charAt(i++));
            } else if (i >= inter.start && i <= inter.end) {
                i = inter.end + 1;
            } else {
                if (j == merged.size() - 1) {
                    sb.append(str.substring(i));
                    return sb.toString();
                } else {
                    inter = merged.get(++j);
                }
            }
        }
        return sb.toString();
    }
}