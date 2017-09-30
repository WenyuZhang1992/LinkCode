/**
 *	Leetcode 17: Letter Combinations of a Phone Number
 *	https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
class LetterCombinationsofPhoneNumber {
	
	/**
	 * Version 1: Use Backtracking
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'q', 'p', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        
        StringBuffer sb = new StringBuffer();
        
        findAllComb(result, map, sb, digits);
        return result;
    }
    
    private void findAllComb(List<String> result, HashMap<Character, char[]> map, StringBuffer sb, String digits) {
        if (sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        
        for (char temp : map.get(digits.charAt(sb.length()))){
            sb.append(temp);
            findAllComb(result, map, sb, digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}