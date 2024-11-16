package com.mali.ds.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* https://leetcode.com/contest/weekly-contest-318/problems/maximum-sum-of-distinct-subarrays-with-length-k/ */
public class MaximumSumofDistinctSubarraysWithLengthK {


    public static long maximumSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long ans = 0;
        for(int i = 0 ; i < k ; i++ ){

            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        if(map.size() == k){
            ans = Math.max(ans, sum);
        }

        for(int i = k ; i < nums.length; i++ ){

            if(map.get(nums[i-k]) > 1){
                map.put(nums[i-k], map.get(nums[i-k])-1);
            } else{
                map.remove(nums[i-k]);
            }
            sum  -= nums[i-k];
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            sum += nums[i];

            if(map.size() == k){
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(maximumSubarraySum(new int[]{9,9,9,1,2,3}, 3));

    }

}
