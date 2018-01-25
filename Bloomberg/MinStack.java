/**
 *	155. Min Stack
 *	https://leetcode.com/problems/min-stack/description/
 */

/** Version 1: Use two stacks
 *       Time: O(1)
 *      Space: O(n)
 */
class MinStack {

	Stack<Integer> stack;
	Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.size() == 0) {
        	minStack.push(x);
        } else {
        	minStack.push(Math.min(minStack.peek(), x));
    	}
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}