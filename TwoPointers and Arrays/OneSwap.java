/**
 *	Given an array, check if the array con be ascending within only one swap.
 */
class OneSwap {

    /**
     * Version 1: Use two pointers, one record the first non-zero position to be replaced, 
     *            the other traversal the array
     *      Time: O(n)
     *     Space: O(1)
     */
	public boolean oneSwap(int[] nums) {
        // 0   1   2   3   4   5
        // 10, 20, 30, 40, 50, 60
        //                      f
        //                        s
        if (nums == null || nums.length < 2) {
            return true;
        }

        int first = 0;
        int second = 1;

        while (first < nums.length - 1) {
            if (nums[first] > nums[first + 1]) {
                break;
            } else {
                first++;
            }
        }

        while (second < nums.length) {
            if (nums[second] < nums[second - 1]) {
                break;
            } else {
                second++;
            }
        }

        // Original array is ascending
        if (first == nums.length - 1 && s == nums.length) {
            return true;
        }

        // swap two elements
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;

        // check again
        int check = 1;
        while (check < nums.length) {
            if (nums[check] < nums[check - 1]) {
                return false;
            } else {
                check++;
            }
        }

        return true;
    }
}