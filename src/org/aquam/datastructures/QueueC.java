package org.aquam.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class QueueC {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");
        System.out.println(queue);
        System.out.println(queue.peek());
        String poll = queue.poll();
        System.out.println(poll);
        queue.poll();
        queue.poll();
        queue.poll();
        queue.peek();
        System.out.println(queue.peek());

    }
}
