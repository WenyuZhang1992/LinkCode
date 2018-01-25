/**
 *	215. Kth Largest Element in an Array
 *	https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
class KthLargestElement {

	/**
	 * Version 1: Use Min Heap to store only K elements
	 *      Time: O(nlogk)
	 *     Space: O(k)
	 */
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length < k) {
			return Integer.MIN_VALUE;
		}

		Queue<Integer> heap = new PriorityQueue<Integer>();

		for (int num : nums) {
			heap.add(num);
			while (heap.size() > k) {
				heap.poll();
			}
		}

		return heap.poll();
	}

	/**
	 * Version 1: Use Quick Select
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return Integer.MIN_VALUE;
        }

        return quickSelect(nums, k-1, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int start, int end) {
        int pivot = nums[start + (end - start) / 2];
        int oldStart = start;
        int oldEnd = end;

        while (start <= end) {
            while (nums[start] > pivot) {
                ++start;
            }

            while (nums[end] < pivot) {
                --end;
            }

            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                ++start;
                --end;
            }
        }

        if (oldStart < end && k <= end) {
            return quickSelect(nums, k, oldStart, end);
        }
        if (start < oldEnd && k >= start) {
            return quickSelect(nums, k, start, oldEnd);
        }
        return nums[k];
    }
}