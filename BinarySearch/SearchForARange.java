public class SearchForARange {
    /** Description:
      * Given a sorted array of n integers, find the starting and ending position of a given target value.
	  * If the target is not found in the array, return [-1, -1].
	  *
	  * Analysis: Obviously use 2-time binary search to achieve O(logn) complexity 
	  *           One for starting position and another for ending position
	  *           The situation (A[middle] == target) is the only difference between these two search procedures, but be careful!!!
	  *
	  * Notice: Special cases: 1. When all array elements == target;
	  *                        2. When target doesn't show in the array;
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] output = new int[2];
        output[0] = -1;
        output[1] = -1;
        if (A == null || A.length == 0){
        	return output;
        }

        int start = 0;
        int end = A.length-1;
        int middle;

        // Search for start position
        while (start+1 < end){
        	middle = start + (end-start)/2;
        	if (A[middle] >= target){
        		end = middle;
        	}
        	else{
        		start = middle;
        	}
        }

        if (A[start] == target && A[end] == target){
        	output[0] = start;
        }
        else if (A[start] != target && A[end] != target){
        	return output;
        }
        else{
        	output[0] = end;
        }

        // Search for end position
        start = output[0];
        end = A.length-1;

        while (start+1 < end){
        	middle = start + (end-start)/2;
        	if (A[middle] > target){
        		end = middle;
        	}
        	else if (A[middle] >= target){
        		start = middle;
        	}
        }

        if (A[start] == target && A[end] == target){
        	output[1] = end;
        }
        else{
        	output[1] = start;
        }

        return output;
    }
}