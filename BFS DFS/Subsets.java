/**
 *	78. Subsets
 *	https://leetcode.com/problems/subsets/description/
 */
class Subsets {
	
	/**
	 * Version 1: Use DFS to get all subsets starting at certain index
	 *      Time: O(n!)
	 *     Space: O(1)
	 */
	public List<List<Integer>> subsets(int[] nums) {
        List result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        //Arrays.sort(nums);
        helper(nums, 0, result, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> path) {
        result.add(new ArrayList<Integer>(path));
        
        for (int i=index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}