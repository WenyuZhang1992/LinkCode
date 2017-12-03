/**
 *	169. Majority Element
 *	https://leetcode.com/problems/majority-element/description/
 */
class MajorityElement {

	/**
	 * Version 1: Sort the array, then pick the element at the middle
	 *      Time: O(nlogn)
	 *     Space: O(1)
	 */
	public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
	 * Version 2: Divide and Conquer
	 *			  Recursively get the max-count element on left half and right half,
	 *			  Return the one with larger count
	 *      Time: O(nlogn)
	 *     Space: O(logn) -> stacks used for recurssion
	 */
	public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(nums, start, end) {
    	if (start == end) {
    		return nums[start];
    	}

    	int mid = start + (end - start) / 2;
    	int left = majorityElement(nums, start, mid);
    	int right = majorityElement(nums, mid + 1, end);

    	if (left == right) {
    		return left;
    	}

    	int leftCount = count(nums, start, mid, left);
    	int rightCount = count(nums, mid + 1, end, right);

    	return leftCount > rightCount ? left : right;
    }

    private int count(int[] nums, int start, int end, int target) {
    	int count = 0;
    	for (int i = start; i <= end; i++) {
    		if (nums[i] == target) {
    			++count;
    		}
    	}

    	return count;
    }

    /**
	 * Version 3: Voting algorithm, similar like XOR
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = Integer.MIN_VALUE;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            } 
            if (num == candidate) {
                ++count;
            } else {
                --count;
            }
        }
        
        return candidate;
    }
}