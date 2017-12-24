/**
 *	31. Next Permutation
 *	https://leetcode.com/problems/next-permutation/description/
 */
class NextPermutation {

	/**
	 * Version 1: Firstly find the largest index k such that nums[k] < nums[k+1], if no such index, this permutation is the last one;
     *            Find largest index l greater than k such that nums[k] < nums[l];
     *            Swap nums[k] with nums[l];
     *            Reverse the sequence from nums[k+1] to the end;
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int index1 = -1;
        int index2 = -1;

        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                index1 = i;
                break;
            }
        }

        if (index1 == -1) {
            int start = 0; 
            int end = nums.length - 1;
            while (start < end) {
                swap(nums, start++, end--);
            }
            
            return;
        }
        for (int i = nums.length - 1; i > index1; --i) {
            if (nums[i] > nums[index1]) {
                index2 = i;
                break;
            }
        }

        swap(nums, index1, index2);
        int start = index1 + 1;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}