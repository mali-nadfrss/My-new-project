package com.mali.ds.arrays;

/* https://leetcode.com/contest/weekly-contest-316/problems/minimum-cost-to-make-array-equal/ */
public class MinimumCosttoMakeArrayEqual {

  public static long minCost(int[] nums, int[] cost) {
    int start = 0;
    int end = 1000001;
    long mc = 0;
    while (start < end) {

      int mid = (start + end) / 2;
      mc = calCost(nums, cost, mid);
      long mc1 = calCost(nums, cost, mid - 1);
      long mc2 = calCost(nums, cost, mid + 1);
      if (mc <= mc1 && mc <= mc2) {
        return mc;
      } else if (mc1 < mc) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return mc;
  }

  static long calCost(int[] nums, int[] costs, int mid) {
    long cost = 0;
    for (int j = 0; j < nums.length; j++) {
      cost += (long) Math.abs(nums[j] - mid) * costs[j];
    }
    return cost;
  }

  public static void main(String[] args) {

    int[] nums = {
      735103, 366367, 132236, 133334, 808160, 113001, 49051, 735598, 686615, 665317, 999793, 426087,
      587000, 649989, 509946, 743518
    };

    int[] costs = {
      724182, 447415, 723725, 902336, 600863, 287644, 13836, 665183, 448859, 917248, 397790, 898215,
      790754, 320604, 468575, 825614
    };
    System.out.println(minCost(nums, costs));
  }
}
