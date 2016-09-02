/**
     * Description:
     * For a given sorted array (ascending order) and a target number, 
     * find the first index of this number in O(log n) time complexity.
     * If the target number does not exist in the array, return -1.
     *
     * Example:
     * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
     * 
     * Analysis: sorted array and target number are symbols for binary search 
     *           with complexity of O(logn)
     *
     * Notice: 1. Special cases when array is null or length is 0;
     *         2. Loop condition (start+1 < end), stops when start is next to end;
     *         3. Assign middle: middle = start + (end - start)/2, avoid overflow;
     *         4. Compare cases: ==, <, >;
     */

class FirstPositionOfTarget {

    public int binarySearch(int[] nums, int target) {
        
        if (nums.length==0||nums==null){
            return -1;
        }
        
        int length, start, end, middle;
        length = nums.length;
        start = 0;
        end = length-1;
        
        while (start+1 < end){
            middle = start + (end - start)/2;
            if (target > nums[middle]){
                start = middle;
            }
            else{
                end = middle;
            }
        }
        if (nums[start]==target){
            return start;
        }
        else if(nums[end]==target){
            return end;
        }
        else{
            return -1;
        }
        
    }
}