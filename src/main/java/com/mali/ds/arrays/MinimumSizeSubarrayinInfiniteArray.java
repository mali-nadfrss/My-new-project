package com.mali.ds.arrays;

/* https://leetcode.com/contest/weekly-contest-365/problems/minimum-size-subarray-in-infinite-array/ */
public class MinimumSizeSubarrayinInfiniteArray {

  public static int minSizeSubarray(int[] nums, int target) {

    long sum = 0;
    int tt = target;
    for (int i : nums) {
      sum += i;
    }
    int n = nums.length;
    if (sum == target) return n;
    if (sum < target) {
      target -= (target / sum) * sum;
    }
    if (target == 0) return (int) (tt / sum);

    int ans = Integer.MAX_VALUE;
    int start = 0;
    int val = 0;
    for (int i = 0; i < n; i++) {
      val += nums[i];
      while (val > target) {
        val -= nums[start++];
      }
      if (val == target) ans = Math.min(i - start + 1, ans);
    }

    for (int i = 0; i < n && start < n; i++) {
      val += nums[i];
      while (val > target && start < n) {
        val -= nums[start++];
      }
      if (val == target) ans = Math.min(i + n - start + 1, ans);
    }
    if (ans == Integer.MAX_VALUE) return -1;
    if (tt > sum) {
      ans += (tt / sum) * n;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {17, 4, 3, 14, 17, 6, 15};
    int target = 85;

    System.out.println(minSizeSubarray(nums, target));
  }
}
