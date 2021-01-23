package com.mali.ds.hashing;

import java.util.HashMap;
import java.util.Map;

/*
 * easy 2
 * https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence-1587115620/1/?track=dsa-workshop-1-hashing&batchId=308#
 * */
public class ConsecutiveIntegers {
    // Function to find Longest Consecutive Subsequence
    static int findLongestConseqSubseq(int a[], int n) {

        // Your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], 0);
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {

            if (map.get(a[i]) == 0) {
                int k = a[i] + 1;
                int temp = 1;
                while (map.containsKey(k)) {
                    temp++;
                    map.put(k, 1);
                    k++;
                }
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 12, 11, 4, 5, 10, 66, 77};
        System.out.println(findLongestConseqSubseq(arr, 10));
    }

}
