package com.mali.ds.dp.distinctWays;

/*
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * Medium
 * */
public class NumberOfLongestIncreasingSubsequence {

  public static int findNumberOfLIS(int[] nums) {
    int[] count = new int[nums.length + 1];
    recursion(nums, 0, Integer.MIN_VALUE, count, 0);

    // once we have counts for all lengths , return the maximum lengths count
    for (int i = count.length - 1; i >= 0; i--) {
      if (count[i] > 0) return count[i];
    }
    return 0;
  }

  // we have 2 choices either to count the number or ignore it.
  static void recursion(int[] nums, int i, int curMax, int[] count, int ans) {
    if (i >= nums.length) {
      // base condition, if our sequence stops increasing increment the count of that length and
      // return
      count[ans] = count[ans] + 1;
      return;
    }

    // count the number if its valid
    if (curMax < nums[i]) {
      recursion(nums, i + 1, nums[i], count, ans + 1);
    }

    // ignore the number
    recursion(nums, i + 1, curMax, count, ans);
  }
  // using binary search
  public static int findNumberOfLISII(int[] arr) {
    int len = arr.length;

    for (int i = 1; i < len; i++) {
      int start = 0;
      int end = i;
      while (start < end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] < arr[end]) {
          end = mid;
        } else {
          start = mid + 1;
        }
      }
      arr[end] = arr[i];
    }

    int ans = 1;

    for (int i = 1; i < len; i++) {
      if (arr[i] > arr[i - 1]) {
        ans++;
      } else {
        break;
      }
    }

    return ans;
  }

  public static void main(String[] args) {

    System.out.println(findNumberOfLISII(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    System.out.println(
        findNumberOfLISII(
            new int[] {
              2, 2, 2, 2, 2,
            }));
  }
}
