package com.mali.ds.dp;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/* https://leetcode.com/problems/closest-subsequence-sum/description/ */
public class ClosestSubsequenceSum {

  public static int minAbsDifference(int[] nums, int goal) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    recursion(nums, 0, 1 + nums.length / 2, 0, set1);
    recursion(nums, 1 + nums.length / 2, nums.length, 0, set2);
    TreeSet<Integer> set = new TreeSet<>(set2);
    int ans = Integer.MAX_VALUE;
    set.remove(0);
    set1.remove(0);
    for (int i : set1) {
      if (set.contains(goal - i)) return ans = 0;
      if (set.lower(goal - i) != null) ans = Math.min(ans, Math.abs(set.lower(goal - i)));
      if (set.higher(goal - i) != null) ans = Math.min(ans, Math.abs(set.higher(goal - i)));
    }
    return ans;
  }

  static void recursion(int[] nums, int i, int max, int sum, Set<Integer> set) {
    if (i == max) {
      set.add(sum);
      return;
    }
    recursion(nums, i + 1, max, sum, set);
    recursion(nums, i + 1, max, sum + nums[i], set);
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    int goal = -7;
    minAbsDifference(nums, goal);
  }
}
