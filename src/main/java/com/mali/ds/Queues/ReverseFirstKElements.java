package com.mali.ds.Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        //add code here.
        Stack<Integer> s = new Stack<>();
        int i = 0;
        int size = q.size();
        k = k % size;
        while (i < k && !q.isEmpty()) {
            s.push(q.poll());
            i++;
        }
        while (!s.isEmpty()) {
            q.offer(s.pop());
        }
        while (k < size) {
            int j = q.poll();
            q.offer(j);
            k++;
        }
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        System.out.println(modifyQueue(q, 3));
    }
}
