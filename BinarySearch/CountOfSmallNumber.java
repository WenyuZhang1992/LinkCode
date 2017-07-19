import java.util.*;

/**
 * Count of Smaller Number
 *
 * Description:
 * Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) and an query list. 
 * For each query, give you an integer, return the number of element in the array that are smaller than the given integer.
 *
 */
public class CountOfSmallNumber {

    /**
     * Version 1: Use Binary Search, find the first orrurrence of query number
     *      Time: O(mlogn)
     *     Space: O(1)
     */
    public static ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (queries == null || queries.length == 0) {
            return result;
        }
        if (A == null || A.length == 0) {
            for (int i=0; i<queries.length; i++) {
                result.add(0);
            }
            return result;
        }

        Arrays.sort(A);

        for (int i=0; i<queries.length; i++) {
            result.add(smallerNumberCount(A, queries[i]));
        }

        return result;
    }

    private static int smallerNumberCount(int[] A, int target) {
        int start = 0;
        int end = A.length;
        int mid;

        while (end - start > 1) {
            mid = start + (end - start)/2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[start] >= target) {
            return start;
        }
        else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }

    
}