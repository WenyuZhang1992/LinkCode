/**
 *	11. Container With Most Water
 *	https://leetcode.com/problems/container-with-most-water/description/
 */
class ContainerWithMostWater {

	/**
	 * Version 1: Use two pointers
	 *            Everytime only move the lower side pointer
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public int maxArea(int[] height) {
        int area = 0;
        int start = 0; 
        int end = height.length - 1;
        
        while (start < end) {
            area = Math.max(area, (end - start) * Math.min(height[start], height[end]));
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        
        return area;
    }
}