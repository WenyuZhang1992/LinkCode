/**
 *	78. Subsets90. Subsets II
 *	https://leetcode.com/problems/subsets-ii/description/
 */
class SubsetsII {
	
	/**
	 * Version 1: Use DFS to get all subsets starting at certain index
	 *      Time: O(n!)
	 *     Space: O(1)
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        helper(nums, result, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] nums, List<List<Integer>> result, int index, ArrayList<Integer> path) {
        result.add(new ArrayList<Integer>(path));
        
        for (int i = index; i < nums.length; i++) {
                if (i != index && nums[i] == nums[i-1]) {
                    continue;
                }
                path.add(nums[i]);
                helper(nums, result, i+1, path);
                path.remove(path.size() - 1);
        }
    }
}