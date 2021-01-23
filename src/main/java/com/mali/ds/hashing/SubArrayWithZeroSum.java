package com.mali.ds.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * easy 2 : Largest subarray with 0 sum
 * https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1/?track=dsa-workshop-1-hashing&batchId=308
 * */
public class SubArrayWithZeroSum {
    static int maxLen(int arr[], int n) {
        // Your code here
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr, 8));
    }
}
