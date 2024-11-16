package com.mali.ds.trees;

/* https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree/description/ */
public class MakeCostsofPathsEqualinaBinaryTree {

  public static int minIncrements(int n, int[] cost) {

    int[] sum = new int[n];
    recursion(cost, sum, 1);
    return ans;
  }

  static int ans = 0;

  static int recursion(int[] cost, int[] sum, int index) {
    if (index > cost.length) return 0;
    int l = recursion(cost, sum, 2 * index);
    int r = recursion(cost, sum, 2 * index + 1);
    ans += Math.abs(l - r);
    sum[index - 1] = Math.max(l, r) + cost[index - 1];
    return sum[index - 1];
  }

  public static void main(String[] args) {
    int n = 7;
    int[] cost = {1, 5, 2, 2, 3, 3, 1};

    minIncrements(n, cost);
  }
}
