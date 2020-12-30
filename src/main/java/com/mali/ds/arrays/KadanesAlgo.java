package com.mali.ds.arrays;

import java.util.Arrays;

/* https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1/?track=dsa-workshop-1-arrays&batchId=308 */
public class KadanesAlgo {

    static  int maxSubArraySum(int arr[], int n){

        // Your code here
        int sum = arr[0];
        int ans = arr[0];
        for (int i = 1; i < n ; i++) {
            sum = Math.max(sum+arr[i], arr[i]);
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public static void main(String[] args) {


        System.out.println(maxSubArraySum(new int[]{1, 2, 3, -2, 5},5 ));
    }
}
