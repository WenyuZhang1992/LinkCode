/**
 *	Partition an array into two parts and the two parts have the same sum
 */
class PartitionArray {

	/** Version 1: Use two sum arrays to record pre-sum and post-sum
	 *             Find the position that two arrays has the same value
     *       Time: O(n)
     *      Space: O(n)
     */
	public int partitionArray(int[] nums) {
		if (nums == null || nums.length < 2) {
            return -1;
        }
        
        int[] pre = new int[nums.length + 1];
        int[] post = new int[nums.length + 1];

        pre[0] = 0;
        post[post.length - 1] = 0;

        for (int i = 1; i < pre.length; i++) {
            pre[i] = nums[i-1] + pre[i-1];
            post[post.length - i - 1] = post[post.length - i] + nums[nums.length - i];
        }

        for (int i = 0; i < pre.length; i++) {
            if (pre[i] == post[i]) {
                return i - 1;
            }
        }

        return -1;
	}

    /** Version 2: Use total sum and preSum, find an index satisfies: (sum - preSum == preSum)
     *       Time: O(n)
     *      Space: O(1)
     */
    public int partitionArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (sum - preSum == preSum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] argv) {
        Solution s = new Solution();
        int[] nums = {1,90, 50, 30, 5, 3, 2, 1};
        int index = s.partitionArray(nums);
        if (index < 0) {
            System.out.println("There is no such split!");
        } else {
            System.out.print("First part of the array: [");
            for (int i = 0; i <= index; i++) {
                System.out.print(" " + nums[i] + " ");
            }
            System.out.print("]\nSecond part of the array: [");
            for (int i = index + 1; i < nums.length; i++) {
                System.out.print(" " + nums[i] + " ");
            }
            System.out.println("]");
        }
    }
}