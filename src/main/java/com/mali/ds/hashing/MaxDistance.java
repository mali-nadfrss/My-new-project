package com.mali.ds.hashing;

import java.util.HashMap;
import java.util.Map;

/* marks 2 : easy
 * https://practice.geeksforgeeks.org/problems/max-distance-between-same-elements/1/?track=dsa-workshop-1-hashing&batchId=308
 *  */
public class MaxDistance {

    static int maxDistance(int arr[], int n) {
        // Your code here
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int temp = i - map.get(arr[i]);
                ans = Integer.max(temp, ans);
            } else {
                map.put(arr[i], i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        System.out.println(maxDistance(arr, 12));
    }
}
