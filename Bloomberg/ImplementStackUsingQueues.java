/**
 *	225. Implement Stack using Queues
 *	https://leetcode.com/problems/implement-stack-using-queues/description/
 */

/**
 * Version 1: Use two queues;
 *            push() takes O(1);
 *            pop() takes O(n);
 *      Time: O(n)
 *     Space: O(n)
 */
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (q1.size() != 0) {
            q1.add(x);
        } else {
            q2.add(x);
        }
        
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q1.size() == 0) {
            while (q2.size() > 1) {
                top = q2.poll();
                q1.add(top);
            }
            return q2.poll();
        } else {
            while (q1.size() > 1) {
                top = q1.poll();
                q2.add(top);
            }
            return q1.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.size() == 0 && q2.size() == 0;
    }
}

/**
 * Version 2: Use two queues;
 *            push() takes O(n) -> insert new elements to empty queue, then add all element after the new element;
 *            pop() takes O(1);
 *      Time: O(n)
 *     Space: O(n)
 */
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q2.add(x);
        while (q1.size() > 0) {
            q2.add(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int temp = q1.poll();
        if (q1.size() > 0) {
            top = q1.peek();
        }
        return temp;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.size() == 0 && q2.size() == 0;
    }
}

/**
 * Version 3: Use one queues;
 *            push() takes O(n);
 *            pop() takes O(1);
 *      Time: O(n)
 *     Space: O(n)
 */
class MyStack {

    Queue<Integer> queue;
    
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        while (size-- > 0) {
            queue.add(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}