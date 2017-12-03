/**
 *	15. 3Sum
 *  https://leetcode.com/problems/3sum/description/
 */
class ThreeSum {

    /** Version 1: Use integer array to check if two strings are anagrams
     *       Time: O(nm)
     *      Space: O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List result = new ArrayList();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            } else {
                List<Integer> list = findTwoSum(nums, i + 1, -nums[i]);
                if (list.size() > 0) {
                    result.addAll(list);
                }
            }
        }

        return result;
    }

    private List<List<Integer>> findTwoSum(int[] nums, int index, int target) {
        List result = new ArrayList();
        if (index < 0 || index >= nums.length) {
            return result;
        }

        int start = index;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] == target) {
                List<Integer> list = new ArrayList();
                list.add(-target);
                list.add(nums[start++]);
                list.add(nums[end--]);
                result.add(list);

                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }

                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        return result;
    }
}