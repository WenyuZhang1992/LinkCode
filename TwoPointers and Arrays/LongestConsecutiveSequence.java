/**
 *	128. Longest Consecutive Sequence
 *	https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
class LongestConsecutiveSequence {

	/**
	 * Version 1: Use HashSet to store all elements
     *            A start position i is regarded as set doesn't contain (nums[i] - 1)
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet();
        for (int i : nums) {
            set.add(i);
        }
        
        int result = Integer.MIN_VALUE;
        for (int i : nums) {
            if (!set.contains(i-1)) {
                int temp = i + 1;
                while (set.contains(temp)) {
                    temp++;
                }
                
                result = Math.max(result, temp - i);
            }
        }
        
        return result;
    }
}