package com.mali.ds.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/subsets/
medium
 */
public class Subsets {
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    // backTrack(ans, new ArrayList<>(), nums, 0);
    for (int i = 0; i < (int) Math.pow(2, nums.length); i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < nums.length; j++) {
        if ((i & (1 << j)) > 0) list.add(nums[j]);
      }
      ans.add(list);
    }
    return ans;
  }

  static void backTrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int start) {
    ans.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }
      tempList.add(nums[i]);
      backTrack(ans, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    System.out.println(subsets(nums));
  }
}
