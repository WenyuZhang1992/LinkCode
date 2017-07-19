import java.util.*;

/** Description:
      * There is an integer array which has the following features:
      * 1.The numbers in adjacent positions are different.
      * 2.A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
      * We define a position P is a peek if:
      * A[P] > A[P-1] && A[P] > A[P+1]
      * Find a peak element in this array. Return the index of the peak.
     */
class FindPeakElement {
    /**
     * Version 1: Use Binary Search, compare the mid with its adjacents
     *      Time: O(logn)
     *     Space: O(1)
     */
    public static int findPeak(int[] A) {
        if (A == null || A.length <= 0)
            return Integer.MIN_VALUE;

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (end - start > 2) {
            mid = start + (end - start)/2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1])
                return mid;

            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return A[start + 1];
    }
}
