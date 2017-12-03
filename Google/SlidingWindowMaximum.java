/**
 *	239. Sliding Window Maximum
 *	https://leetcode.com/problems/sliding-window-maximum/description/
 */
class SlidingWindowMaximum {

	/**
	 * Version 1: Use TreeMap to record value-position pair
     *            Every movement: 
     *                  -> Check the removed value's last index is out or not,
     *                  -> Check the if the max value needs to be updated
     *                  -> Add the new elements
	 *      Time: O(nlogk)
	 *     Space: O(k)
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        int start = 0;
        int end = k - 1;

        // Initialize the map
        int max = nums[start];
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            System.out.println(max + " " + i);
            map.put(nums[i], i);
        }

        result[start++] = max;
        while ((start + k - 1) < nums.length) {
            end = start + k - 1;
            int removed = nums[start - 1];

            // If remove the max
            if (removed == max && map.get(removed) < start) {
                if (map.lowerKey(max) == null) {
                    max = nums[end];
                } else {
                    max = map.lowerKey(max);
                }
                map.remove(removed);
            } else if (removed != max && map.get(removed) != null && map.get(removed) < start) {
                // If remove some other value
                map.remove(removed);
            }

            if (nums[end] >= max) {
                max = nums[end];
            }
            map.put(nums[end], end);
            result[start++] = max;
        }

        return result;
    }

    /**
     * Version 2: Use a heap
     *      Time: O(nlogk)
     *     Space: O(k)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Queue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2.intValue() - i1.intValue();
            }
        });
        int start = 0;
        int end = k - 1;

        // Initialize the heap
        for (int i = start; i <= end; i++) {
            heap.add(nums[i]);
        }

        int[] result = new int[nums.length - k + 1];
        result[start++] = heap.peek();
        while (start + k - 1 < nums.length) {
            end = start + k - 1;
            int removed = nums[start - 1];
            int added = nums[end];

            heap.remove(removed);
            heap.add(added);
            result[start++] = heap.peek();
        }

        return result;
    }

    /**
     * Version 3: Use a Deque to store the index of elements
     *            Every time when adding a new element:
     *                  -> Check if the head of the queue already outside the window
     *                  -> Remove all values that are smaller than the new incoming element
     *                  -> Add the new element's index into the queue
     *            This solution makes sure that all index residing in the queue is inside the window
     *            The elements representing by the index are in non-increasing order
     *      Time: O(n)
     *     Space: O(k)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (!list.isEmpty() && list.peekFirst() < i - k + 1) {
                list.removeFirst();
            }
            while (!list.isEmpty() && nums[list.peekLast()] < value) {
                list.removeLast();
            }
            list.addLast(i);
            
            if (i >= k - 1) {
                result[i - k + 1] = nums[list.peek()];
            }
        }
        
        return result;
    }
}