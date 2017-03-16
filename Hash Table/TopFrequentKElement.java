import java.util.*;

public class Solution {

	public static void main(String args[] ) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3};
        List<Integer> result = topKFrequent(arr, 1);
        for (int i=0; i<result.size(); i++) {
        	System.out.print(result.get(i));
        }
    }
	/* Version 1: HashMap + Heap
     * Time Complexity: Traverse the array and form a HashMap -> O(n)
     *                  Form a MinHeap with size=k -> O(n*logk)
     *                                                worst case n entries
     *                                                maintain k entries -> n compares and each compare take O(logk)
     */
	private static Comparator<Map.Entry<Integer, Integer>> entryComparator = new Comparator<Map.Entry<Integer, Integer>>() {
		public int compare(Map.Entry<Integer, Integer> left, Map.Entry<Integer, Integer> right) {
			return left.getValue()-right.getValue();
		}
	};
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
        	if (!map.containsKey(nums[i])) {
        		map.put(nums[i], 1);
        	}
        	else
        		map.put(nums[i], map.get(nums[i])+1);
        }
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<Map.Entry<Integer, Integer>>(entryComparator);
        for ( Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if (heap.size() < k)
        		heap.offer(entry);
        	else if (heap.peek().getValue() < entry.getValue()) {
        		heap.poll();
        		heap.offer(entry);
        	}
        }
        List<Integer> result = new LinkedList<Integer>();
        for (Map.Entry<Integer, Integer> entry : heap) 
        	result.add(entry.getKey());
        return result;
        
    }

    /* Version 2: Bucket Sort
     * Time Complexity: Traverse the array and form a HashMap -> O(n)
     *                  Traverse the HashMap twice -> O(n)
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        int max = 0;
        for (int m : map.values()) {
            max = Math.max(max, m);
        }
        List<Integer>[] bucket = new List[max+1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            int elem = entry.getKey();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(elem);
        }
        List<Integer> result = new LinkedList<Integer>();
        for (int pos = bucket.length - 1; pos >= 0 && result.size() < k; pos--) {
            if (bucket[pos] != null) {
                result.addAll(bucket[pos]);
            }
        }
        return result;
    }
}