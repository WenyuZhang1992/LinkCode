/**
 *	295. Find Median from Data Stream
 *	https://leetcode.com/problems/find-median-from-data-stream/description/
 */

/** Version 1: Use a MinHeap and a MaxHeap;
 *             Maintain the size difference of minHeap and maxHeap to be at most 1; 
 *       Time: O(logn) -> O(logn) for addNum() operation, findMedian() takes O(1)
 *      Space: O(n)
 */
public class MedianFinder {

    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2.intValue() - i1.intValue();
            }
        });
    }

    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()) {
            return (double)minHeap.peek();
        } else {
            return (double)maxHeap.peek();
        }
    }
}