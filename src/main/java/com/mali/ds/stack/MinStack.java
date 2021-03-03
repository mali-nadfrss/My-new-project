package com.mali.ds.stack;

import java.util.Stack;

/*
 * medium 4
 * https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack
 */
public class MinStack {

    int minEle;
    Stack<Integer> s = new Stack<>();

    int size() {
        return s.size();
    }

    boolean isEmpty(){
        return s.isEmpty();
    }

    int peek() {
        int i = s.peek();
        if (i < minEle) {
            return minEle;
        }
        return i;
    }

    /*returns min element from stack*/
    int getMin() {
        // Your code here
        if (!s.isEmpty()) {
            return minEle;
        }
        return -1;
    }

    /*returns poped element from stack*/
    int pop() {
        // Your code here
        if (s.isEmpty()) {
            return -1;
        }
        int i = s.pop();
        if (i < minEle) {
            this.minEle = 2 * minEle - i;
            return minEle;
        }
        return i;
    }

    /*push element x into the stack*/
    void push(int x) {
        // Your code here
        if (s.isEmpty()) {
            this.minEle = x;
            s.push(x);
        } else {
            if (x < minEle) {
                s.push(2 * x - this.minEle);
                this.minEle = x;
            } else {
                s.push(x);
            }
        }

    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(3);
        m.push(2);
        m.push(1);
        while (m.size() > 0) {
            System.out.println(m.getMin());
            System.out.println(m.pop());
        }
    }
}
