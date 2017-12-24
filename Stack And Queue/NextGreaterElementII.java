/**
 *	503. Next Greater Element II
 *	https://leetcode.com/problems/next-greater-element-ii/description/
 */
class NextGreaterElementII {

	/**
	 * Version 1: Use stack to keep indexes and traverse nums twice
	 *      Time: O(n) -> traverse nums twice
	 *     Space: O(n)
	 */
	public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        HashMap<Integer, Integer> map = new HashMap();
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < nums.length; i++) {
            while (stack.size() != 0 && nums[i] > nums[stack.peek()]) {
                int temp = stack.pop();
                map.put(temp, nums[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() != 0 && nums[i] > nums[stack.peek()]) {
                int temp = stack.pop();
                map.put(temp, nums[i]);
            }
            stack.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(i)) {
                nums[i] = -1;
            } else {
                nums[i] = map.get(i);
            }
        }

        return nums;
    }
}