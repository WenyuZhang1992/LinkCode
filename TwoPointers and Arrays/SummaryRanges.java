/**
 *	228. Summary Ranges
 *	https://leetcode.com/problems/summary-ranges/description/
 */
class SummaryRanges {
	
	/**
	 * Version 1: Use 3 pointers to traverse the array
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int start = 0;
        int curr = 1;
        int prev = 0;
                
        while (curr < nums.length) {
            if (nums[curr] - nums[prev] == 1) {
                prev++;
                curr++;
            } else {
                String rst = nums[start] == nums[prev] ? String.valueOf(nums[start]) : nums[start] + "->" + nums[prev];
                result.add(rst);
                start = curr;
                prev = curr;
                curr = curr + 1;
            }
        }
        
        if (start < nums.length) {
            String rst = nums[start] == nums[nums.length - 1] ? 
                String.valueOf(nums[start]) : nums[start] + "->" + nums[nums.length - 1];
            result.add(rst);
        }
        
        return result;
    }
}