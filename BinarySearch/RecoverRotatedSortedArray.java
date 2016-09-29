 public class RecoverRotatedSortedArray {
    /** Description:
      * Given a rotated sorted array, recover it to sorted array in-place.
      * 
      * Example: [4,5,1,2,3] -> [1,2,3,4,5]
      *
      * Analysis: Not quite suitable for binary search cause it allows duplicates in arrays
      *           So we need to spot the rotated position and then reverse the array, so it will take O(n)
      *           3-Step to reverse the array:
      *                                       1. [4,5,1,2,3] -> [5,4,1,2,3]
      *                                       2. [5,4,1,2,3] -> [5,4,3,2,1]
      *                                       3. [5,4,3,2,1] -> [1,2,3,4,5]
      *
      * Notice: When we find the rotated position, make i starts from 1 and compare nums.get(i), nums.get(i-1)
      *         In such way, we will not go out of index bound.
     */
    public static void reverse(ArrayList<Integer> nums, int start, int end){
    	int temp;
    	for (int i=start, j=end; i<j; i++, j--){
    		temp = nums.get(i);
    		nums.set(i, nums.get(j));
    		nums.set(j, temp);
    	}
    }

    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // Find the rotated position firstly
        for (int i=1; i<nums.size(); i++){
        	if (nums.get(i)<nums.get(i-1)){
        		reverse(nums, 0, i);
        		reverse(nums, i, nums.size()-1);
        		reverse(nums,0,nums.size()-1);
        		break;
        	}
        }
        

    }
}