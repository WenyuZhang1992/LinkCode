/**
 *	42. Trapping Rain Water
 *	https://leetcode.com/problems/trapping-rain-water/description/
 */
class TrappingRainWater {

	/**
	 * Version 1: Use decreasing stack which stores only index
     *            Everytime getting a larger element, calculate the water amount using continuous three heights 
	 *      Time: O(n) -> every index only being pushed and popped once respectively
	 *     Space: O(n)
	 */
	public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            while (stack.size() != 0 && height[i] > height[stack.peek()]) {
                int prev = stack.pop();
                if (stack.size() == 0) {
                    break;
                }
                
                int dist = i - stack.peek() - 1;
                int bounded_height = Math.max(Math.min(height[i], height[stack.peek()]) - height[prev], 0);
                result += dist * bounded_height;
            }
            stack.push(i);
        }
        
        return result;
    }
}