package com.mali.ds.stack;

import java.util.Stack;

/*
 *medium 4
 * https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620
 * */
public class MaxAreaHistogram {

    // Function to calculate max rectangular area histogram
    // hist[]: input array
    // n: size of array
    public static long getMaxArea(long[] hist, long n) {
        // your code here
        Stack<Integer> s = new Stack<>();
        long maxArea = 0;
        long area = 0;
        int i = 0;
        for (; i < n; ) {
            if (s.isEmpty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            } else {
                int k = s.pop();
                if (s.isEmpty()) {
                    area = hist[k] * i;
                } else {
                    area = hist[k] * (i - s.peek() - 1);
                }
            }
            maxArea = Math.max(maxArea, area);
        }

            while (!s.isEmpty()) {
            int k = s.pop();
            if (s.isEmpty()) {
                area = hist[k] * i;
            } else {
                area = hist[k] * (i - s.peek() - 1);
            }
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        long[] arr = {0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0};
        System.out.print(getMaxArea(arr, arr.length));
    }
}
