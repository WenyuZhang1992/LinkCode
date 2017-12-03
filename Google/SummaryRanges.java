/**
 *	228. Summary Ranges
 *	https://leetcode.com/problems/summary-ranges/description/
 */
class SummaryRanges {

	/**
	 * Version 1: Use Two Pointers
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int start = 0;
        int mid = start;
        int end = 1;
        
        while (end < nums.length) {
            if (nums[end] == nums[mid] + 1) {
                mid = end;
                end++;
            } else if (end - start == 1) {
                result.add(String.valueOf(nums[start]));
                start = end;
                mid = start;
                end = start + 1;
            } else {
                result.add(nums[start] + "->" + nums[mid]);
                start = end;
                mid = start;
                end = start + 1;
            }
        }
        
        if (end - start == 1) {
            result.add(String.valueOf(nums[start]));
        } else {
            result.add(nums[start] + "->" + nums[mid]);
        }
        
        return result;
    }
}