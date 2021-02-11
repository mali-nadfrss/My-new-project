package com.mali.ds.stack;

import java.util.Stack;

/*
 * Medium 4
 * https://practice.geeksforgeeks.org/problems/parenthesis-checker2744
 * */
public class Parenthesis {

    static boolean isPar(String x) {
        // add your code here
        Stack<Character> s = new Stack<>();
        for (char c : x.toCharArray()) {
            if (s.isEmpty() && (c == '}' || c == ')' || c == ']')) {
                return false;
            } else if (c == '}' && s.peek() != '{') {
                return false;
            } else if (c == ')' && s.peek() != '(') {
                return false;
            } else if (c == ']' && s.peek() != '[') {
                return false;
            } else if (c == '}' || c == ')' || c == ']') {
                s.pop();
            } else {
                s.push(c);
            }
        }
        return s.isEmpty();
    }
}
