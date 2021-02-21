package com.mali.ds.Queues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * medium 4
 * geeks
 * */
public class MaxOfAllSubArrays {

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k && i < n; i++) {
            q.add(arr[i]);
        }
        ans.add(q.peek());

        for (int i = k; i < n; i++) {
            q.remove(arr[i - k]);
            q.add(arr[i]);
            ans.add(q.peek());
        }
        return ans;
    }

    public static void main(String args[]) {

        int[] arr = {1, 2, 3, 5, 4, 4, 5, 1, 1, 1};
        System.out.print(max_of_subarrays(arr, 10, 3));
    }
}
