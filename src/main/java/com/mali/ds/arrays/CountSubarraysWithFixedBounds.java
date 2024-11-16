package com.mali.ds.arrays;

/* https://leetcode.com/contest/weekly-contest-315/problems/count-subarrays-with-fixed-bounds/ */
public class CountSubarraysWithFixedBounds {

  public static long countSubarrays(int[] nums, int minK, int maxK) {
    int ans = 0;

    for (int i = 0; i <nums.length; i++) {
      int min = -1;
      int max = -1;
      for (int j = i; j < nums.length; j++) {
        if (nums[j] == minK){
          min = minK;
        }
        if (nums[j] == maxK){
          max = maxK;
        }
        if (nums[j] < minK || nums[j] > maxK){
          min = -1;
          max = -1;
        }
        if (minK == min && maxK == max){
          ans++;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {

    countSubarrays(new int[] {1, 2, 5,1}, 1, 5);
  }
}
