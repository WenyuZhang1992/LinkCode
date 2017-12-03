/**
 *	Reverse partial of the array
 */
class ReversePartialArray {

	public void reversArray(int[] nums, int i, int j) {
		if (nums == null || nums.length < 1 || i >= j) {
			return;
		}

		int start = Math.max(i, 0);
		int end = Math.min(j, nums.length);

		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}