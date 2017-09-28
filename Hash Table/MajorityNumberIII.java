import java.util.*;

/**
 * Majority Number III
 *
 * Given an array of integers and a number k, 
 * the majority number is the number that occurs more than 1/k of the size of the array.
 *
 */

class MajorityNumberIII {

	public int majorityNumber(List<Integer> nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (nums == null || nums.size() == 0) {
			return Integer.MIN_VALUE;
		}

		for (Integer i : nums) {
			if (nums.contains(i)) {
				
			}
		}
	}

}