package com.mali.ds.dp.distinctWays;

/* https://leetcode.com/problems/knight-dialer/
 * medium
 * */
public class KnightDialer {

  public static int knightDialer(int n) {
    int ans = 0;
    Integer[][][] dp = new Integer[n + 1][4][3];
    // start the knight from each part of the dial pad, so that all possible combinations are
    // covered
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        ans = (ans + recursion(i, j, n, dp)) % MOD;
      }
    }
    return ans;
  }

  // these are possible positions where knight can go next
  static int[][] pos =
      new int[][] {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

  static int MOD = 1000000007;
  // dail pad has 4X3 size
  public static int recursion(int i, int j, int n, Integer[][][] dp) {
    // if it comes out of box return 0
    if (i >= 4 || i < 0 || j < 0 || j >= 3 || (i == 3 && (j != 1)) || n < 0) {
      return 0;
    }
    if (n == 1) return 1;
    if (dp[n][i][j] != null) return dp[n][i][j];
    int ans = 0;
    for (int[] row : pos) {
      ans = (ans + recursion(i + row[0], j + row[1], n - 1, dp)) % MOD;
    }
    dp[n][i][j] = ans % MOD;
    return dp[n][i][j];
  }

  public static void main(String[] args) {
    System.out.println(knightDialer(3131));
  }
}
