/**
 *	15. 3Sum
 *	https://leetcode.com/problems/3sum/description/
 */
class ThreeSum {

	/**
	 * Version 1: Use two pointers, degrade 3Sum to 2Sum
	 *      Time: O(n^2)
	 *     Space: O(1)
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List result = new ArrayList();
		if (nums == null || nums.length < 3) {
			return result;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				twoSum(nums, i + 1, -nums[i], result);
			}
		}

		return result;
	}

	private void twoSum(int[] nums, int index, int target, List result) {
		if (index > nums.length - 2) {
			return;
		}

		int start = index;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] == target) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(-target);
				list.add(nums[start]);
				list.add(nums[end]);
				result.add(list);
				start++;
				end--;

				while (start < end && nums[start - 1] == nums[start]) {
					start++;
				}
				while (end > start && nums[end] == nums[end + 1]) {
					end--;
				}
			} else if (nums[start] + nums[end] > target) {
				end--;
			} else {
				start++;
			}
		}
	}
}