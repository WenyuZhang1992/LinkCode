package BinarySearch;

import java.util.*;

/**
 * Description:
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * return -1 if my number is lower, 1 if my number is higher, otherwise return 0
 * 
 * Analysis: sorted array and target number are symbols for binary search 
 *           with complexity of O(logn)
 */
public class GuessNumberGame {

	/**
     * Version 1: Use Binary Search
     *      Time: O(logn)
     *     Space: O(1)
     */
	public int guessNumber(int n) {
        if (n < 1)
        	return 0;

        int start = 1;
        int end = n;
        int mid;

        while (end - start > 1) {
            mid = start + (end - start)/2;
        	if (guess(mid) == 0) {
        		return mid;
        	} else if (guess(mid) == 1) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }

        if (guess(start) == 0)
        	return start;
        if (guess(end) == 0)
        	return end;
        return 0;
    }
}