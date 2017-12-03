/**
 *	128. Longest Consecutive Sequence
 *	https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
class LongestConsecutiveSequence {

	/**
	 * Version 1: Use a HashSet to contains all elements
     *            For every smallest element in a consecutive consequence, increment until the value not exist in HashSet
	 *      Time: O(n) -> every element only reaches at most twice O(2n)
     *                    First time check if the element is a smallest element in a consecutive sequence
     *                    Second time be reached when increment the smallest element
	 *     Space: O(1)
	 */
	public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }

        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (!set.contains(nums - 1)) {
                int temp = num;
                while (set.contains(temp)) {
                    temp++;
                }
                result = Math.max(result, temp - num);
            }
        }

        return result;
    }
}