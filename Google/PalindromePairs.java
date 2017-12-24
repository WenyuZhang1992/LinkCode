/**
 *	336. Palindrome Pairs
 *	https://leetcode.com/problems/palindrome-pairs/description/
 */
class PalindromePairs {

	/**
	 * Version 1: Use a HashMap to store the reverse of words
     *            For every word in words[], separate it into left and right parts
     *            If any of left and right is a palindrome and the other contained in map, we can construct a Palindrome Pair
     *            Edge case: when the empty string contained in the words[]
	 *      Time: O(nk^2) -> k indicates the length of largest word
     *                       traverse through the word takes O(k), check palindrome also takes O(k) so it's O(k^2)
	 *     Space: O(n)
	 */
	public List<List<Integer>> palindromePairs(String[] words) {
        List result = new ArrayList();
        if (words == null || words.length == 0) {
            return result;
        }
        
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            map.put(sb.reverse().toString(), i);
        }
        
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                index = i;
            }
        }
        
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            // Handle the situation {"", "a"}
            // Situation {"a", ""} will be handled later
            if (isPalindrome(word) && index != -1 && index != i) {
                list.clear();
                list.add(index);
                list.add(i);
                result.add(new ArrayList<Integer>(list));
            }
            for (int j = 0; j < word.length(); j++) {
                String left = word.substring(0, j); // left could contains empty string
                String right = word.substring(j);   // right at least contains one character
                
                if (map.containsKey(left) && isPalindrome(right) && map.get(left) != i) {
                    list.clear();
                    list.add(i);
                    list.add(map.get(left));
                    result.add(new ArrayList<Integer>(list));
                }
                if (map.containsKey(right) && isPalindrome(left) && map.get(right) != i) {
                    list.clear();
                    list.add(map.get(right));
                    list.add(i);
                    result.add(new ArrayList<Integer>(list));
                }
            }
        }
        
        return result;
    }
    
    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}