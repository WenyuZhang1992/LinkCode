/**
 *	349. Intersection of Two Arrays
 *	https://leetcode.com/problems/intersection-of-two-arrays/description/
 */
class IntersectionofTwoArrays {
	
	/**
	 * Version 1: Use two HashSet
	 *      Time: O(n)
	 *     Space: O(n)
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        HashSet<Integer> s1 = new HashSet();
        HashSet<Integer> result = new HashSet();

        for (int i : nums1) {
            s1.add(i);
        }

        for (int j : nums2) {
            if (s1.contains(j)) {
                result.add(j);
            }
        }

        int[] ans = new int[result.size()];
        int count = 0;
        for (int rt : result) {
            ans[count] = rt;
            count++;
        }

        return ans;
    }

    /**
     * Version 1: Sort two arrays, use two pointers and one HashSet
     *      Time: O(nlogn)
     *     Space: O(n)
     */
    public int[] intersectionII(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        HashSet<Integer> result = new HashSet();

        int p1 = 0;
        int p2 = 0;String

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                result.add(nums1[p1]);
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                p1++;
            }
        }

        int[] ans = new int[result.size()];
        int count = 0;
        for (int rt : result) {
            ans[count++] = rt;
        }

        return ans;
    }
}