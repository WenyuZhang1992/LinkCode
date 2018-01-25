/**
 *	Count Negative Numbers:
 *	Given a 2-D array, whose rows and columns are sorted.
 *  Count negative numbers
 */
class CountNegativeNumbers {

	/**
	 * Version 1: Traverse from top right
	 *      Time: O(m + n)
	 *     Space: O(1)
	 */
	public int countNegative(int[][] nums) {
		if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
			return Integer.MIN_VALUE;
		}

		int i = 0;
		int j = nums[0].length - 1;
		int count = 0;
		while (i < nums.length && j >= 0) {
			if (nums[i][j] < 0) {
				count += (j + 1);
				i++;
			} else {
				j--;;
			}
		}

		return count;
	}

	/**
	 * Version 2: Use Binary Search
	 *      Time: O(m * logn)
	 *     Space: O(1)
	 */
	public int countNegative1(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return 0;
        }

        int count = 0;
        int rightBound = nums[0].length - 1;

        for (int i = 0; i < nums.length; ++i) {
            rightBound = binarySearch1(nums[i], rightBound);
            count += (rightBound + 1);
        }

        return count;
    }

    // Return index of rightest negative element in row
    private int binarySearch1(int[] nums, int bound) {
        if (bound < 0) {
            return -1;
        }
        int start = 0;
        int end = bound;
        int mid;

        while (start < (end - 1)) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= 0) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[end] < 0) { return end; }
        if (nums[start] < 0) { return start; }

        return -1;
    }

}