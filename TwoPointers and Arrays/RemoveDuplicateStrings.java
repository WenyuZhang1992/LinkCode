/**
 *	Given a list of strings, remove duplicate strings in the list, 
 *  and return a list with unique strings in the original order. 
 *  Time Complexity O(n). Assume space is not a problem. 
 */
class RemoveDuplicateStrings {

	public List<Integer> removeDuplicateStrings(List<String> strings) {
        if (strings == null || strings.size() < 2) {
            return strings;
        }

        HashSet<String> set = new HashSet();

        int start = 1;
        int end = 1;

        set.add(strings.get(0));

        while (end < strings.size()) {
            if (set.contains(strings.get(end))) {
                end++;
            } else {
                set.add(strings.get(end));
                strings.set(start, strings.get(end));
                start++;
                end++;
            }
        }

        // Note here how to remove all tailing elements
        while (start < strings.size()) {
            strings.remove(start);
        }

        return strings;
    }
}