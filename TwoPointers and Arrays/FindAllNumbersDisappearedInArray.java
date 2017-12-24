/**
 *	448. Find All Numbers Disappeared in an Array
 *	https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
class FindAllNumbersDisappearedInArray {

	/**
	 * Version 1: Everytime we encounter a element, move it back to the position it should be util the position already taken by the right element
     *            For example, element 5 should be swapped to nums[4] unless nums[4] is already set to 5
	 *      Time: O(n) -> at most we will swap (n-1) times so it's totally O(n) for swapping
	 *     Space: O(1)
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i+1);
            }
        }
        
        return result;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Version 2: Traverse the array once, add (nums.length + 1) to all corresponding position of occured elements
     *            For example: If element 2 occurs once, should add (nums.length + 1) to nums[1]
     *                         If element 3 occurs twice, should add 2 * (nums.length + 1) tp nums[2]
     *            Then traverse the array again and check: nums[i] / (nums.length + 1)
     *                         -> 0 means disappeared
     *                         -> 1 means occurred once
     *                         -> 2 means occurred twice
     *            Explanation: After first traversal, every position should have value in format -> k * (n + 1) + i
     *                         Where k is the count of occurrance, i is the original value in this position
     *                         After division by (n + 1), the result is only k
     *      Time: O(n)
     *     Space: O(1)
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {

            // Use nums[i] % (nums.length + 1) to obtain original value in this position
            nums[nums[i]%(nums.length + 1) - 1] += (nums.length + 1);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] / (nums.length + 1) == 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}