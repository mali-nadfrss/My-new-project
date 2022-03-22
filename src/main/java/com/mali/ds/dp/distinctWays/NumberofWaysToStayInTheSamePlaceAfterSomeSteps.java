package com.mali.ds.dp.distinctWays;

import java.util.Arrays;

/* https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 * Hard
 *  */
public class NumberofWaysToStayInTheSamePlaceAfterSomeSteps {

  public static int numWays(int steps, int arrLen) {

    // tricky part, actual dp is dp[steps][arrLen]
    // but we can max go up to steps len and need to return so we can use
    // dp[steps][steps]
    int[][] dp = new int[steps + 1][steps];

    for (int[] row : dp) Arrays.fill(row, -1);

    return recursion(steps, arrLen, 0, dp);
  }

  static final int MOD = 1000000007;

  /* 0  - stay , 1 - right , 2 - left  */
  static int recursion(int steps, int arrLen, int index, int[][] dp) {

    if (steps == 0 && index == 0) {
      return 1;
    }

    // extra base condition is index> steps , because we cannot return from there at all.
    if (steps == 0 || index < 0 || index >= arrLen || index > steps) return 0;

    if (dp[steps][index] != -1) return dp[steps][index];

    int ans = 0;

    // we can go either left , right or stay there itself.
    ans = (ans + recursion(steps - 1, arrLen, index, dp)) % MOD;
    ans = (ans + recursion(steps - 1, arrLen, index + 1, dp)) % MOD;
    ans = (ans + recursion(steps - 1, arrLen, index - 1, dp)) % MOD;
    dp[steps][index] = ans % MOD;
    return dp[steps][index];
  }

  public static void main(String[] args) {
    System.out.println(numWays(434, 291270));
  }
}
