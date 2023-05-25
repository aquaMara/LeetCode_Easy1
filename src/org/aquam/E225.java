package org.aquam;

import java.util.LinkedList;
import java.util.Queue;

// 5/14/2023
// 225. Implement Stack using Queues
public class E225 {

    public static void main(String[] args) {

        /*
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        System.out.println(q.peek());   // [0]=1,[1]=2, takes [0]
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        System.out.println(s.peek());   // [0]=1,[1]=2, takes [size-1]
         */

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.top());
        myStack.push(3);
        System.out.println(myStack.top());
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.empty());

    }
}

class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        while (queue.size() != 1)
            temp.offer(queue.poll());
        Integer x = queue.poll();
        while (!temp.isEmpty())
            queue.offer(temp.poll());
        return x;
    }

    public int top() {
        Queue<Integer> temp = new LinkedList<>();
        while (queue.size() != 1)
            temp.offer(queue.poll());
        Integer x = queue.poll();
        while (!temp.isEmpty())
            queue.offer(temp.poll());
        queue.offer(x);
        return x;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively.
 * You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 *
 * Example 1:
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 *
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 *
 *
 * Constraints:
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 *
 * Follow-up: Can you implement the stack using only one queue?
 */