package com.mali.ds.dp;

/* https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/ */
public class NinjasTraining {

  static int recursion(int[][] points, int prev, int index, int[][] dp) {
    if (index < 0) return 0;
    if (dp[index][prev] > 0) return dp[index][prev];
    if (prev == 0)
      dp[index][prev] =
          points[index][prev]
              + Math.max(recursion(points, 1, index - 1, dp), recursion(points, 2, index - 1, dp));
    else if (prev == 1)
      dp[index][prev] =
          points[index][prev]
              + Math.max(recursion(points, 0, index - 1, dp), recursion(points, 2, index - 1, dp));
    else
      dp[index][prev] =
          points[index][prev]
              + Math.max(recursion(points, 1, index - 1, dp), recursion(points, 0, index - 1, dp));
    return dp[index][prev];
  }

  // tabulation -> just add dp in place of prev
  static int ninjaTraining(int n, int[][] points) {

    int prev0 = 0;
    int prev1 = 0;
    int prev2 = 0;

    for (int i = n - 1; i >= 0; i--) {
      int temp0 = points[i][0] + Math.max(prev1, prev2);
      int temp1 = points[i][1] + Math.max(prev0, prev2);
      int temp2 = points[i][2] + Math.max(prev0, prev1);
      prev0 = temp0;
      prev1 = temp1;
      prev2 = temp2;
    }

    System.out.println(Math.max(prev0, Math.max(prev1, prev2)));
    int[][] dp = new int[n + 1][3];
    return recursion(points, 2, n - 1, dp);
  }

  public static void main(String args[]) {
    int[][] points = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
    int n = points.length;
    System.out.println(ninjaTraining(n, points));
  }
}
