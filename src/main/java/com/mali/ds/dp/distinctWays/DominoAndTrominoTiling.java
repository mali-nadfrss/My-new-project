package com.mali.ds.dp.distinctWays;

/*
 * https://leetcode.com/problems/domino-and-tromino-tiling/
 * medium
 * */
public class DominoAndTrominoTiling {

  /*
   * logic is more, finally turns out to be dp[n] = 2*dp[n-1]+dp[n-3];
   * */
  //todo
  public static int numTilings(int n) {
    return 1;
  }

  static int recursion(int n, int i, int j, int count, int[][] dp) {
    if (i > 1 || j >= n) return 0;
    if (count == 0) return 1;

    return 1;
  }
}
