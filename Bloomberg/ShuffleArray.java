/**
 *	384. Shuffle an Array
 *	https://leetcode.com/problems/shuffle-an-array/description/
 */

/** Version 1: Traverse the array, for each position i visited, generate a random number j in range [0, i], swap nums[i] and nums[j];
 *             In this way, every element is randomly swapped;
 *       Time: O(n)
 *      Space: O(n)
 */
class ShuffleArray {

    int[] original;
    Random random;
    
    public ShuffleArray(int[] nums) {
        original = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = Arrays.copyOf(original, original.length);
        for (int i = 0; i < result.length; ++i) {
            int j = random.nextInt(i + 1);
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }

        return result;
    }
}