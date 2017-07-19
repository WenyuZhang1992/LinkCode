import java.util.*;

/**
 * Intersection of Two Arrays
 *
 * Description:
 * Given two arrays, write a function to compute their intersection.
 * 1. Each element in the result must be unique.
 * 2. The result can be in any order.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 */
class IntersectionOfTwoArrays {

	/**
     * Version 1: Use Hash Set to store all unique elements of nums1, then find match from nums2
     *      Time: O(m + n)
     *     Space: O(m)
     */
	public static int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
        	return new int[0];

        if (nums1.length > nums2.length)
        	return intersection(nums2, nums1);

        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();

        // Add all unique elements of nums1 into HashSet
        for (int i=0; i<nums1.length; i++) {
        	set1.add(nums1[i]);
        }

        // Find match from nums2
        for (int j=0; j<nums2.length; j++) {
        	if (set1.contains(nums2[j])) {
        		set2.add(nums2[j]);
        	}
        }

        // Transform into array
        int[] result = new int[set2.size()];
        int index = 0;
        for (int i : set2) {
        	result[index++] = i;
        }

        return result;
    }

    /**
     * Version 2: Use Binary Search. Sort one array, and chekc if elements of set2 existing in sorted array
     *      Time: O(nlogm)
     *     Space: O(1)
     */
	public static int[] intersection2(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
        	return new int[0];

        // Sort nums1
        Arrays.sort(nums1);

        HashSet<Integer> elems = new HashSet<Integer>();

        // Find elements in nums1 using binary search
        for (int i=0; i<nums2.length; i++) {
        	if (elems.contains(nums2[i]))
        		continue;
        	if (findValue(nums1, nums2[i]))
        		elems.add(nums2[i]);
        }

        // Assign intersection elements into an array
        int[] result = new int[elems.size()];
        int index = 0;
        for (int i : elems) {
        	result[index++] = i;
        }

        return result;
	}

	private static boolean findValue(int[] nums1, int target) {
		int start = 0;
		int end = nums1.length - 1;
		int mid;

		while (end - start > 1) {
			mid = start + (end - start)/2;
			if (nums1[mid] == target) {
				return true;
			} else if (nums1[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (nums1[start] == target || nums1[end] == target)
			return true;
		return false;
	}

	/**
     * Version 3: Use two pointers, sort two arrays then use two pointers to traverse arrays
     *      Time: 
     *     Space: O(1)
     */
	public static int[] intersection3(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
        	return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;
        HashSet<Integer> set = new HashSet<Integer>();

        while (index1 < nums1.length && index2 < nums2.length) {
        	if (nums1[index1] == nums2[index2]) {
        		set.add(nums1[index1]);
        		index1++;
        		index2++;
        	} else if (nums1[index1] > nums2[index2]) {
        		index2++;
        	} else {
        		index1++;
        	}
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (int i : set) {
        	result[index++] = i;
        }

        return result;
	}

    public static void main(String[] argv) {
    	int[] nums1 = {4,7,9,7,6,7};
    	int[] nums2 = {5,0,0,6,1,6,2,2,4};

    	int[] result = intersection2(nums1, nums2);
    	System.out.print("[ ");
    	for (int i=0; i<result.length; i++) {
    		System.out.print(result[i] + " ");
    	}
    	System.out.println("]");
    }
}