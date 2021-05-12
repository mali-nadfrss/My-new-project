package com.mali.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backTracking(ans, nums, 0);
    return ans;
  }

  static void backTracking(List<List<Integer>> ans, int[] nums, int start) {
    if (start == nums.length) {
      List<Integer> temp = new ArrayList<>();
      for (int i : nums) {
        temp.add(i);
      }
      ans.add(temp);
      return;
    }

    for (int i = start; i < nums.length; i++) {
      if (i>start && nums[i] == nums[start]) {
        continue;
      }
      swap(nums, start, i);
      backTracking(ans, nums, start + 1);
      swap(nums, start, i);
    }
  }

  static void swap(int[] nums, int start, int i) {
    int k = nums[start];
    nums[start] = nums[i];
    nums[i] = k;
  }

  public static void main(String[] args) {
    int[] nums = {0, 1, 2};
    System.out.println(permute(nums));
  }
}
