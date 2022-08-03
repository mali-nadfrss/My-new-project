package com.mali.ds.hashing;

import java.util.*;

/*
 * medium 4
 * https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825
 * */
public class ZeroSumSubArray {

    public static int findSubarray(int[] arr, int n) {
        //Your code here
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        //put zero in the map initially
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            //add the cumulative sum for every index
            sum = sum + arr[i];
            if (map.containsKey(sum)) {
                //if map already contains that sum ..
                // it means sub array sum at this index is zero add that many times to ans
                ans = ans + map.get(sum);
                //increment the number of times we have encountered the sum
                map.put(sum, map.get(sum) + 1);
            } else {
                // else case just save the sum value in map with value of zero
                map.put(sum, 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A[] = {0, 0, 5, 5, 0, 0};
        System.out.println(findSubarray(A, 6));
    }

}
