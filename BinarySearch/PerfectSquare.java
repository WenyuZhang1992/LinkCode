/**
 *	Check if a number is a perfect square
 *
 *  Example: 4 -> true
 *           3 -> false
 */
class PerfectSquare {

    /**
     * Version 1: Use binary search to check range 0 ~ (n/2+1)
     *      Time: O(logn)
     *     Space: O(1)
     */
	public boolean perfectSquare(int n) {
        if (n < 0) {
            return false;
        }

        int start = 0;
        int end = n / 2 + 1;
        int mid;

        while (end - start > 1) {
            mid = start + (end - start) / 2;
            if (mid * mid == n) {
                return true;
            } else if (mid * mid > n) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (start * start == n || end * end == n) {
            return true;
        }

        return false;
    }
}