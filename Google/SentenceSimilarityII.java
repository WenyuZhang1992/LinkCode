/**
 *	737. Sentence Similarity II
 *	Given two sentences words1, words2 (each represented as an array of strings), 
 *  and a list of similar word pairs pairs, determine if two sentences are similar.
 *  
 *  Note that the similarity relation is transitive. 
 *  For example, if “great” and “good” are similar, and “fine” and “good” are similar, then “great” and “fine” are similar.
 *
 *  However, similarity is symmetric. For example, “great” and “fine” being similar is the same as “fine” and “great” being similar.
 */
class SentenceSimilarityII {

	/**
	 * Version 1: Use HashMap and Union Find
	 *      Time: O(W + P) -> length of words plus length of pairs
	 *     Space: O(P) -> space of pairs
	 */
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length == 0 && words2.length == 0) {
            return true;
        } else if (words1.length == 0 || words2.length == 0) {
            return false;
        }
        if (words1.length != words2.length) {
            return false;
        }

        HashMap<String, String> map = new HashMap<String, String>();
        for (String[] pair : pairs) {
            union(pair[0], pair[1], map);
        }

        int index = 0;
        while (index < words1.length) {
            if (!words1[index].equals(words2[index])) {
                if (map.containsKey(words1[index]) && map.containsKey(words2[index])
                        && find(words1[index], map).equals(find(words2[index], map))) {
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

    private String find(String word, HashMap<String, String> map) {
        if (map.get(word).equals(word)) {
            return word;
        }
        return find(map.get(word), map);
    }

    private void union(String word1, String word2, HashMap<String, String> map) {
        if (!map.containsKey(word1)) {
            map.put(word1, word1);
        }
        if (!map.containsKey(word2)) {
            map.put(word2, word2);
        }

        String x = find(word1, map);
        String y = find(word2, map);
        map.put(x, y);
    }
}