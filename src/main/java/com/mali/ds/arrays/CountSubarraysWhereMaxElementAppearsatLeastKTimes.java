package com.mali.ds.arrays;

/* https://leetcode.com/contest/weekly-contest-375/problems/count-subarrays-where-max-element-appears-at-least-k-times/ */
public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {

  public static long countSubarrays(int[] nums, int k) {

    int len = nums.length;

    int max = 0;

    for (int num : nums) {
      max = Math.max(num, max);
    }

    int count = 0;
    long ans = 0;
    int start = 0;
    int i = 0;
    for (; i < len; i++) {
      if (nums[i] == max) {
        count++;
      }
      if (count == k) {
        ans += len - i;
        while (nums[start] != max) {
          ans += len - i;
          start++;
        }
        start++;
        ans += func(start, i + 1, nums, len, max, k);
        break;
      }
    }

    return ans;
  }

  static long func(int start, int i, int[] nums, int len, int max, int k) {
    long ans = 0;
    for (; i < len; i++) {
      if (nums[i] == max) {
        ans += len - i;
        while (nums[start++] != max) {
          ans += len - i;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {
      61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78,
      15, 82
    };
    int k = 2;
    countSubarrays(nums, k);
  }
}
