package com.mali.ds.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/contest/weekly-contest-337/problems/the-number-of-beautiful-subsets/ */
public class TheNumberofBeautifulSubsets {

  static int count = 0;

  public static int beautifulSubsets(int[] nums, int k) {
    Arrays.sort(nums);
    backTrack(new HashSet<>(), 0, nums, k);
    System.out.println(count - 1);
    return count - 1;
  }

  private static void backTrack(Set<Integer> element, int i, int[] nums, int k) {
    count++;
    for (int j = i; j < nums.length; j++) {
      if (!element.contains(nums[j] - k)) {
        element.add(nums[j]);
        backTrack(element, j + 1, nums, k);
        element.remove(nums[j]); // remove current elem before backtracking
      }
    }
  }

  public static void main(String[] args) {
    beautifulSubsets(new int[] {1, 1, 2, 3}, 1);
  }
}
