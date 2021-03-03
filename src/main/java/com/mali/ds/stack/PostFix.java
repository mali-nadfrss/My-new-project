package com.mali.ds.stack;

import java.util.Stack;

/* Easy 2
 * https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/
 * */
public class PostFix {

    public static int evaluatePostFix(String S) {
        // Your code here
        Stack<Integer> s = new Stack<>();
        for (Character c : S.toCharArray()) {
            if (c >= '0' && c <= '9') {
                s.push(c - '0');
            } else {
                int i1 = s.pop();
                int i2 = s.pop();
                if (c == '*') {
                    s.push(i1 * i2);
                } else if (c == '/') {
                    s.push(i2 / i1);
                } else if (c == '-') {
                    s.push(i2 - i1);
                } else if (c == '+') {
                    s.push(i1 + i2);
                }
            }
        }

        return s.pop();
    }

    public static void main(String[] args) {
        System.out.print(evaluatePostFix("231*+9-"));
    }

}
