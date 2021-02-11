package com.mali.ds.stack;

import java.util.Stack;

/*
 * Medium 4
 * https://practice.geeksforgeeks.org/problems/max-rectangle/
 * */
public class MaxArea {

    public static int maxArea(int M[][], int m, int n) {
        // add code here.
        int ans = histogram(M[0], n);

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) {
                    M[i][j] = 0;
                } else {
                    M[i][j] = M[i - 1][j] + M[i][j];
                }
            }
            ans = Math.max(histogram(M[i], n), ans);
        }

        return ans;
    }

    public static int histogram(int[] hist, int n) {
        // your code here
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int area = 0;
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
        int[][] arr = {{0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0}};
        System.out.print(maxArea(arr, 1, 12));
    }

}
