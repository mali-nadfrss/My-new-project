package com.mali.ds.stack;

import java.util.Stack;

/*
 * hard 8
 * https://practice.geeksforgeeks.org/problems/355f731797ea1acbd5ab698b19eb1c3c469aa837/1/
 * */
public class GeekBuilding {

    static boolean recreationalSpot(int[] arr, int n) {
        // Your code goes here
        Stack<Integer> s = new Stack<>();
        int[] arr1 = new int[n];
        arr1[0] = arr[0];
        int small = arr[0];
        for (int i = 1; i < n; i++) {
            if (small > arr[i]) {
                small = arr[i];
            }
            arr1[i] = small;
        }
        s.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            int next = s.isEmpty() ? Integer.MAX_VALUE : arr[s.peek()];
            if (arr[i] > arr1[i] && arr[i] > next && arr1[i] < next) {
                return true;
            }
            s.push(i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2};
        System.out.print(recreationalSpot(arr, 4));
    }
}
