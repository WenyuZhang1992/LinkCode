import java.util.*;

class TwoSum {
	
	/**
 	 * Two Sum
 	 *
 	 * Given an array of integers, find two numbers such that they add up to a specific target number.
 	 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 	 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.
 	 *
 	 * Analysis: Use a HashMap to store the value difference from target and index
 	 *     Time: O(n)
 	 *    Space: O(n)
 	 */
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0) {
			return new int[0];
		}

		// Key stores difference between from target
		// Value stores index
		HashMap<Integer, Integer> map = new HashMap();
		int[] result = new int[2];

		for (int i=0; i < numbers.length; i++) {
			if (map.contains(numbers[i])) {
				result[0] = map.get(numbers[i]) + 1;
				result[1] = i + 1;
			} else {
				map.put(target - numbers[i], i);
			}
		}

		return new int[0];
	}

	/**
 	 * Two Sum - Input array is sorted
 	 *
 	 * Given an array of integers that is already sorted in ascending order, 
 	 * find two numbers such that they add up to a specific target number.
 	 *
 	 * Analysis: Use two pinters to navigate through the array
 	 *     Time: O(n)
 	 *    Space: O(n)
 	 */
	public int[] twoSumSorted(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
        	return new int[0];
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
        	int sum = nums[start] + nums[end];
        	if (sum == target) {
        		int[] result = {start + 1, end + 1};
        		return result;
        	} else if (sum > target) {
        		end--;
        	} else {
        		start++;
        	}
        }
        return new int[0];
    }
	
}