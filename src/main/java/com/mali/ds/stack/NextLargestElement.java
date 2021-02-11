package com.mali.ds.stack;

import java.util.Stack;

public class NextLargestElement {
    public static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        Stack<Integer> s = new Stack<>();
        long[] ans = new long[n];
        ans[n - 1] = -1;
        s.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            ans[i] = !s.isEmpty() ? arr[s.peek()] : arr[i];
            s.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        long[] arr = {1, 3, 2, 4};
        System.out.print(nextLargerElement(arr, 4));
    }
}
