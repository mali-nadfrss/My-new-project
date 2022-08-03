package com.mali.ds.algorithms;

/* https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1/?track=dsa-workshop-1-arrays&batchId=308 */
public class KadanesAlgo {

    static int maxSubArraySum(int arr[], int n) {

        // Your code here
        int sum = arr[0];
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    static int kadanesVer2(int[] arr){
        int ans = 0;
        int cur = 0;
    for (int i = 1; i < arr.length; i++) {
      cur = Integer.max(0, cur+arr[i] - arr[i-1]);
      ans = Integer.max(ans, cur);
    }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[]{1, 2, 3, -2, 5}, 5));
        System.out.println(kadanesVer2(new int[]{7,1,6,99,4,8}));
    }
}
