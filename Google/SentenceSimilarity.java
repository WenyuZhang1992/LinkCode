/**
 *	734. Sentence Similarity
 *	Given two sentences words1, words2 (each represented as an array of strings), 
 *  and a list of similar word pairs pairs, determine if two sentences are similar.
 *  
 *  Note that the similarity relation is not transitive. 
 *  For example, if “great” and “fine” are similar, and “fine” and “good” are similar, “great” and “good” are not necessarily similar.
 *
 *  However, similarity is symmetric. For example, “great” and “fine” being similar is the same as “fine” and “great” being similar.
 */
class SentenceSimilarity {

	/**
	 * Version 1: Use HashMap to store similar pairs
	 *      Time: O(W + P) -> length of words plus length of pairs
	 *     Space: O(P) -> space of pairs
	 */
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length == 0 && words2.length == 0) {
            return true;
        } else if (words1.length == 0 || words2.length == 0) {
            return false;
        }
        if (words1.length != words2.length) {
            return false;
        }

        HashMap<String, HashSet<String>> map = new HashMap();
        for (String[] pair : pairs) {
            if (map.containsKey(pair[0])) {
                map.get(pair[0]).add(pair[1]);
            } else {
                HashSet<String> set = new HashSet<String>();
                set.add(pair[1]);
                map.put(pair[0], set);
            }
        }

        int index = 0;
        while (index < words1.length) {
            if (!words1[index].equals(words2[index])) {
                if (map.containsKey(words1[index]) && map.get(words1[index]).contains(words2[index])) {
                    ++index;
                    continue;
                }
                if (map.containsKey(words2[index]) && map.get(words2[index]).contains(words1[index])) {
                    ++index;
                    continue;
                }
                break;
            }
            ++index;
        }

        if (index == words1.length) {
            return true;
        } else {
            return false;
        }
    }
}