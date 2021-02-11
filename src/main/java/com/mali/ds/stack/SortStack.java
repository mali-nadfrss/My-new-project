package com.mali.ds.stack;

import java.util.Stack;

public class SortStack {

    public static Stack<Integer> sort(Stack<Integer> s) {
        //add code here.
        Stack<Integer> ans = new Stack<>();
        while (!s.isEmpty()) {
            int i = s.pop();
            if (ans.isEmpty()) {
                ans.push(i);
            } else if (i > ans.peek()) {
                ans.push(i);
            } else {
                while (!ans.isEmpty()) {
                    if (ans.peek() > i) {
                        s.push(ans.pop());
                    } else {
                        break;
                    }
                }
                ans.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.print(sort(s));
    }
}
