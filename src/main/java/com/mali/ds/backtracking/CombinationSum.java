package com.mali.ds.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<Integer> individualList = new ArrayList<>();
    List<List<Integer>> finalList = new ArrayList<>();
    combinationSum(candidates, individualList, finalList, target, 0);
    combinationSumWithoutRepetition(candidates, individualList, finalList, target, 0);
    return finalList;
  }

  public static void combinationSumWithoutRepetition(
          int[] candidates,
          List<Integer> individualSolution,
          List<List<Integer>> finalList,
          int target,
          int index) {

    if (target == 0) {
      finalList.add(new ArrayList<>(individualSolution));
      return;
    } else if (target < 0) {
      return;
    }

    // starting the iteration from given index as the previous elements have already been visited
    // multiple times to calculate the sum
    for (int i = index; i < candidates.length; i++) {
      if (candidates[i] <= target) {
        individualSolution.add(candidates[i]);
        // start the next iteration from the same index
        combinationSumWithoutRepetition(candidates, individualSolution, finalList, target - candidates[i], i+1);
        individualSolution.remove(individualSolution.size()-1);
      }
    }
  }

  public static void combinationSum(
      int[] candidates,
      List<Integer> individualSolution,
      List<List<Integer>> finalList,
      int target,
      int index) {

    if (target == 0) {
      finalList.add(new ArrayList<>(individualSolution));
      return;
    } else if (target < 0) {
      return;
    }

    // starting the iteration from given index as the previous elements have already been visited
    // multiple times to calculate the sum
    for (int i = index; i < candidates.length; i++) {
      if (candidates[i] <= target) {
        individualSolution.add(candidates[i]);
        // start the next iteration from the same index
        combinationSum(candidates, individualSolution, finalList, target - candidates[i], i);
        individualSolution.remove(individualSolution.size()-1);
      }
    }
    System.out.println(individualSolution);
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 5};
    System.out.println(combinationSum(nums, 8));
  }
}
