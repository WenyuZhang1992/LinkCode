import java.util.*;

public class Solution {
    /* LintCode 171: Anagrams
     * 
     */
    public static List<String> anagrams(String[] strs) {
    	List<String> result = new ArrayList<String>();
    	if (strs == null || strs.length == 0)
    		return result;
    	HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
    	for (String str : strs) {
    		int hashcode = hashCode(str);
    		if (map.get(hashcode) != null)
    			map.get(hashcode).add(str);
    		else{
    			ArrayList<String> list = new ArrayList<String>();
    			list.add(str);
    			map.put(hashcode, list);
    		}
    	}
    	
    	for (ArrayList<String> list : map.values()) {
    		if (list.size() > 1)
    			result.addAll(list);
    	}
    	return result;
    }

    // Helper function to obtain hashcode for a string
    // Sort the character array, and construct a string
    // Obtain the hashCode of the string
    // If two string are anagrams
    // After sorting, they will be same string thus have same hashcode
    private static int hashCode(String str) {
    	char[] chars = str.toCharArray();
    	Arrays.sort(chars);
    	String temp = new String(chars);
    	return temp.hashCode();
    }
    
    public static void main(String[] args) {
        String[] strs = {"lint", "intl", "inlt", "code"};
        List<String> result = anagrams(strs);
        for (String str : result){
            System.out.println(str);
        }
    }
}