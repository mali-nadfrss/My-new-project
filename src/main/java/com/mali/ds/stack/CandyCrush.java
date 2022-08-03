package com.mali.ds.stack;

import java.util.Stack;

/*
 * medium 4
 * https://www.geeksforgeeks.org/reduce-the-string-by-removing-k-consecutive-identical-characters/
 * */
public class CandyCrush {

    //use pair below implementation is not correct
    public static String reduced_String(int k, String s) {
        // Your code goes here
        Stack<Character> ans = new Stack<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (count == k) {
                while (count > 0 && !ans.isEmpty()) {
                    ans.pop();
                    count--;
                }
            }
            if (ans.isEmpty() || ans.peek() != c) {
                ans.push(c);
                count = 1;
            } else if (count == k - 1 && ans.peek() == c) {
                while (count > 0 && !ans.isEmpty()) {
                    ans.pop();
                    count--;
                }
            } else {
                ans.push(c);
                count++;
            }
        }
        if (count == k) {
            while (count > 0 && !ans.isEmpty()) {
                ans.pop();
                count--;
            }
        }
        String a = "";
        while (!ans.isEmpty()) {
            a = ans.pop() + a;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.print(reduced_String(2, "uxdctqmzkwfgxfccpnrfapkremmvwkzlyimsyzxlvhgncksajsnffnfitrhhvybkcwxjqejxmmempdbdcaxekpjgutxtvklkpqca"));
    }
}
