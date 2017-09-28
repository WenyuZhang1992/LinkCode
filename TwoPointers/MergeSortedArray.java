import java.util.*;

/**
 * Merge Sorted Array
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 */

class MergeSortedArray {
	
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if (B == null || n == 0) {
            return;
        }
        
        int pa = m - 1;
        int pb = n - 1;
        int end = A.length - 1;
        
        while (pa >= 0 && pb >= 0) {
            if (A[pa] > B[pb]) {
                A[end] = A[pa];
                pa--;
            } else {
                A[end] = B[pb];
                pb--;
            }
            end--;
        }
        
        while (pb >= 0) {
            A[end] = B[pb];
            pb--;
            end--;
        }
    }
}