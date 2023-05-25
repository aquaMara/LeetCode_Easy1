package org.aquam;

import java.util.Stack;

/*
https://leetcode.com/problems/implement-queue-using-stacks/
https://leetcode.com/problems/implement-stack-using-queues/
https://leetcode.com/problems/first-unique-character-in-a-string/
https://leetcode.com/problems/number-of-recent-calls/
https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
https://leetcode.com/problems/time-needed-to-buy-tickets/
 */
// 5/11/2023
// 232. Implement Queue using Stacks
public class E232 {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.peek());
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        myQueue.push(3);
        System.out.println(myQueue.pop());
        myQueue.push(4);
        myQueue.push(5);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        boolean empty = myQueue.empty();
        System.out.println(myQueue);

    }
}

class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        if (!popStack.empty()) {
            while (!popStack.empty())
                pushStack.push(popStack.pop());
        }
        pushStack.push(x);
    }

    public int pop() {
        if (popStack.empty()) {
            while (!pushStack.empty())
                popStack.push(pushStack.pop());
        }
        return popStack.empty() ? -1 : popStack.pop();
    }

    public int peek() {
        if (popStack.empty()) {
            while (!pushStack.empty())
                popStack.push(pushStack.pop());
        }
        return popStack.empty() ? -1 : popStack.peek();
    }

    public boolean empty() {
        return popStack.empty() && pushStack.empty();
    }

}

class MyQueue2 {

    private Stack<Integer> stack;

    public MyQueue2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.empty())
            temp.push(stack.pop());
        stack.push(x);
        while (!temp.empty())
            stack.push(temp.pop());
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }
}

class MyQueue1 {

    private Stack<Integer> stack;

    public MyQueue1() {
        stack = new Stack();
    }

    public void push(int x) {
        if (stack.empty())
            stack.push(x);
        else {
            Stack<Integer> temp = new Stack<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Integer pop = stack.pop();
                temp.push(pop);
            }
            stack.push(x);
            int tempSize = temp.size();
            for (int i = 0; i < tempSize; i++) {
                stack.push(temp.pop());
            }
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }
}

/**
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively.
 * You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 */