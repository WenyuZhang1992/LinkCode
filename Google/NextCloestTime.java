/**
 *  681. Next Cloest Time
 *  Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no *  limit on how many times a digit can be reused.
 *
 *  You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" 
 *  are all invalid.
 *
 */
class NextCloestTime {

    /**
     * Version 1: Continuely increment 1 miniute and transform into valid time format
     *            Check if all characters exists in original time string
     *      Time: O(1440) -> worst case need to increment 1440
     *     Space: O(1)
     */
    public String nextClosestTime(String time) {
        HashSet<Character> set = new HashSet<Character>();
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));

        for (int i = 0; i < time.length(); i++) {
            set.add(time.charAt(i));
        }

        while (true) {
            min = min + 1;
            if (min == 60) {
                min = 0;
                hour = (hour + 1) % 24;
            }
            String curr = String.format("%02d:%02d", hour, min);
            boolean flag = true;
            for (int i = 0; i < curr.length(); i++) {
                if (!set.contains(curr.charAt(i))) {
                    flag = false;
                    break;
                }
            }

            if (flag) { return curr; }
        }
    }
}