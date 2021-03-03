package com.mali.ds.Queues;

import java.util.Stack;

public class QueueUsing2Stacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int x) {
        s1.push(x);
    }

    int pop() {
        if (!s2.isEmpty()) {
            return s2.pop();
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.isEmpty() ? -1 : s2.pop();
        }
    }
}
