/**
 *	438. Find All Anagrams in a String
 *  https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
class FindAllAnagrams {

    /** Version 1: Use integer array to check if two strings are anagrams
     *       Time: O(nm)
     *      Space: O(1)
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        // Construct target array
        int[] target = new int[26];
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            target[index] = target[index] + 1;
        }

        for (int i = 0; i <= s.length() - p .length(); i++) {
            int[] counts = new int[26];
            for (int j = i; j < i + p.length(); j++) {
                int index = s.charAt(j) - 'a';
                counts[index] = counts[index] + 1;
            }

            if (Arrays.equals(target, counts)) {
                result.add(i);
            }
        }

        return result;
    }
}