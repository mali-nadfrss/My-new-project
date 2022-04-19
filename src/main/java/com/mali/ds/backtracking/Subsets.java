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
    backTrack(ans, new ArrayList<>(), nums, 0);
    return ans;
  }

  static void backTrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int start) {
    ans.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i -1]) {
        continue;
      }
      tempList.add(nums[i]);
      backTrack(ans, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3,4};
    System.out.println(subsets(nums));
  }
}
