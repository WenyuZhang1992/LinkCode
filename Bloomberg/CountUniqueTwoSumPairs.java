/**
 *	Count the Number of Unique Two Sum Pairs
 *	Given an array of integers, and a number target, 
 *  Find the number of unique pairs of integers in the array whose sum is equal to target.
 *	
 *	Example: nums = [1, 2, 2, 1], target = 3, return 1
 */
class CountUniqueTwoSumPairs {

	/**
	 * Version 1: Sort the array, then use Two Pointers
	 *      Time: O(nlogn)
	 *     Space: O(1)
	 */
	public int getPairsCount(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return Integer.MIN_VALUE;
		}

		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		int count = 0;

		while (start < end) {
			if (nums[start] + nums[end] == target) {
				++count;
				++start;
				--end;

				while (start < end && nums[start] == nums[start - 1]) {
					++start;
				}
				while (end > start && nums[end] == nums[end + 1]) {
					--end;
				}
			} else if (nums[start] + nums[end] > target) {
				--end;
			} else {
				++start;
			}
		}

		return count;
	}

	/**
	 * Version 2: Use HashMap
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public int getPairsCount(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return Integer.MIN_VALUE;
		}

		HashSet<Integer> set = new HashSet();
		HashSet<Integer> counted = new HashSet();
		int count = 0;

		for (int num : nums) {
			if (set.contains(num) && !counted.contains(Math.min(num, target - num))) {
				++count;
				counted.add(Math.min(num, target - num));
			} else {
				set.add(target - num);
			}
		}

		return count;
	}
}