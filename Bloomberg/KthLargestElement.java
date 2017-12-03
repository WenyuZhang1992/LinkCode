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
}