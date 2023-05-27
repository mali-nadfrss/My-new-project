package com.mali.ds.arrays;

/* https://leetcode.com/contest/biweekly-contest-104/problems/power-of-heroes/ */
public class PowerofHeroes {

  public static int sumOfPower(int[] nums) {
    String s = "sdasd";
    s.indexOf("ab");
    int ans = recursion(0, nums, new int[nums.length]);
    return ans;
  }

  static int recursion(int i, int[] nums, int[] vis) {
    if (vis[i] == 1) return 0;
    int max = nums[i];
    int min = nums[i];
    int ans = max * max * min;
    vis[i] = 1;
    for (int j = i + 1; j < nums.length; j++) {
      max = Math.max(max, nums[j]);
      min = Math.min(min, nums[j]);
      ans += max * max * min;
      ans += recursion(j, nums, vis);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {2, 1, 4};
    sumOfPower(nums);
  }
}
