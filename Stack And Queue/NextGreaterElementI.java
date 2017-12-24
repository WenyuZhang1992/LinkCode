/**
 *	496. Next Greater Element I
 *	https://leetcode.com/problems/next-greater-element-i/description/
 */
class NextGreaterElementI {

	/**
	 * Version 1: Use stack to track elements
	 *      Time: O(n + m) -> n is the length of nums2, m is the length of nums1
	 *     Space: O(n)
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int num : nums2) {
            while (stack.size() != 0 && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                nums1[i] = -1;
            } else {
                nums1[i] = map.get(nums1[i]);
            }
        }
        
        return nums1;
    }
}