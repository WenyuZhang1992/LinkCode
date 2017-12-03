/**
 *	49. Group Anagrams
 *	https://leetcode.com/problems/group-anagrams/description/
 */
class GroupAnagrams {

	/**
	 * Version 1: Sort the string and get HashCode
	 *      Time: O(n*klogk) -> n: count of strings, k: maximum length of a string
	 *     Space: O(n*k)
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List result = new ArrayList();
		if (strs == null || strs.length == 0) {
			return result;
		}

		HashMap<Integer, List<String>> map = new HashMap();
		for (String str : strs) {
			int hashcode = getHashcode(str);
			if (map.containsKey(hashcode)) {
				map.get(hashcode).add(str);
			} else {
				List<String> strList = new ArrayList();
				strList.add(str);
				map.put(hashcode, strList);
			}
		}

		for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}

		return result;
	}

	private int getHashcode(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
        String sorted = new String(charArray);
		return sorted.hashCode();
	}

	/**
	 * Version 2: Use char array to represent the string and get HashCode
	 *      Time: O(n*k) -> n: count of strings, k: maximum length of a string
	 *     Space: O(n*k)
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List result = new ArrayList();
		if (strs == null || strs.length == 0) {
			return result;
		}

		HashMap<Integer, List<String>> map = new HashMap();
		for (String str : strs) {
			int hashcode = getHashcode(str);
			if (map.containsKey(hashcode)) {
				map.get(hashcode).add(str);
			} else {
				List<String> strList = new ArrayList();
				strList.add(str);
				map.put(hashcode, strList);
			}
		}

		for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}

		return result;
	}

	private int getHashcode(String str) {
		int[] chars = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
            int index = (int)(c - 'a');
			chars[index] = chars[index] + 1;
		}
		return Arrays.hashCode(chars);
	}
}