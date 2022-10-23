package com.mali.ds.arrays;

/* https://leetcode.com/problems/count-number-of-nice-subarrays/ */
public class CountNumberofNiceSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {

        int ans = 0;
        int count = 0;
        int[]  arr = new int[nums.length];
        int start = 0;

        for(int i = 0, j = 0 ; i < nums.length ; i++){

            if(nums[i] % 2 == 1){
                count++;
                arr[j++] = i;
                if(count >k){
                    start = arr[start]+1;
                }
            }

            if(count >= k){
                ans += i-start+1;
            }

        }

        return ans;

    }

}
