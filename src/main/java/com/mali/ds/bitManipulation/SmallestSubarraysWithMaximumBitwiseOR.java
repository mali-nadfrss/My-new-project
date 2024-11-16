package com.mali.ds.bitManipulation;

import java.util.Arrays;

/* https://leetcode.com/contest/biweekly-contest-87/problems/smallest-subarrays-with-maximum-bitwise-or/ */
public class SmallestSubarraysWithMaximumBitwiseOR {

  public static int[] smallestSubarrays(int[] nums) {

    int[][] maxArr = new int[nums.length][32];
    int[] ans = new int[nums.length];
    Arrays.fill(ans, 1);
    for (int i = nums.length - 1; i >= 0; i--) {
      int temp = nums[i];
      for (int j = 1; j < 32; j ++) {
        if ((temp & 1) == 1) {
          maxArr[i][j] = i;
        } else if(i+1 < nums.length){
          maxArr[i][j] = maxArr[i+1][j];
          ans[i] = Math.max(ans[i], maxArr[i+1][j]-i+1);
        }
        temp = temp>>1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1,0,2,1,3};
    System.out.println(smallestSubarrays(nums));
  }
}
