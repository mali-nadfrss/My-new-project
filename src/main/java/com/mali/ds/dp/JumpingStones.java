package com.mali.ds.dp;

/*
https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/jump-k-forward-250d464b/
easy
 */
public class JumpingStones {
  static int M = 1000000007;

  static int waysToJump(int n, int k) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 1;
    for (int j = 3; j <= n; j++) {
      int sum = 0;
      for (int i = 1; i <= k; i++) {
        if (j - i < 0) {
          break;
        }
        sum += (dp[j - i]) % M;
      }
      dp[j] = sum % M;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(waysToJump(5, 5));
  }
}
