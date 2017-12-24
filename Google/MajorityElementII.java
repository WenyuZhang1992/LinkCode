/**
 *	229. Majority Element II
 *	https://leetcode.com/problems/majority-element-ii/description/
 */
class MajorityElementII {

    /**
	 * Version 1: Voting algorithm, similar like XOR
     *            Since we can have at most 2 candidates, so we keep track of two candidates
     *            Then, verify if the two candidates really meets our requirement
	 *      Time: O(n) -> traverse twice, first time to find the candidates, second time verify the candidates
	 *     Space: O(1)
	 */
	public int majorityElement(int[] nums) {
        public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int count1 = 0;
        int count2 = 0;
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        
        for (int num : nums) {
            if (num == candidate1) {
                ++count1;
            } else if (num == candidate2) {
                ++count2;
            } else if (count1 == 0) {
                candidate1 = num;
                ++count1;
            } else if (count2 == 0) {
                candidate2 = num;
                ++count2;
            } else {
                --count1;
                --count2;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                ++count1;
            } else if (num == candidate2) {
                ++count2;
            }
        }
        
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }
        
        return result;
    }
}