class FindPeakElement {
    /** Description:
      * There is an integer array which has the following features:
      * 1.The numbers in adjacent positions are different.
      * 2.A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
      * We define a position P is a peek if:
      * A[P] > A[P-1] && A[P] > A[P+1]
      * Find a peak element in this array. Return the index of the peak.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A.length<3 || A == null){
        	return 0;
        }

        int start = 0;
        int end = A.length-1;
        int middle;

        // Solution 1:
        while (start+1 < end){
        	middle = start + (end-start)/2;
        	if (A[middle+1]<A[middle] && A[middle]>A[middle-1]){
        		return middle;
        	}
        	if (A[middle] <= A[end]||A[middle+1]>A[middle]){
        		start = middle;
        	}
        	else if (A[middle] <= A[start]||A[middle-1]>A[middle]){
        		end = middle;
        	}
        }

        /* Solution 2:
        while (start+1 < end){
        	middle = start + (end-start)/2;
        	if (A[middle+1]<A[middle] && A[middle]>A[middle-1]){
        		return middle;
        	}
        	else if (A[middle+1]>A[middle] && A[middle]<A[middle-1]){
        		start = middle;
        	}
        	else if (A[middle+1]>A[middle] && A[middle]>A[middle-1]){
        		start = middle;
        	}
        	else{
        		end = middle;
        	}
        }
        */

        if (A[start]>A[end]){
        	return start;
        }
        else{
        	return end;
        }
    }
}
