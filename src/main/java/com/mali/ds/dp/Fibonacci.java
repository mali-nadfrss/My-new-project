package com.mali.ds.dp;

public class Fibonacci {

  static int fibBasic(int n, int[] dp) {
    // basic exit condition
    if (n == 0 || n == 1) return 1;
    if (dp[n] > 0) return dp[n];
    return dp[n] = fibBasic(n - 1, dp) + fibBasic(n - 2, dp);
  }

  static int fib(int n) {
    int[] dp = new int[50];//100000b
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  static int fibTab(int n){
    //1 1 2 3 5 8
    int prev1 = 1; //1b
    int prev0 = 1; //1b
    for (int i = 2; i <= n; i++) {
      int cur = prev1 + prev0; //1b
      prev0 = prev1;
      prev1 = cur;
    }
    return prev1;
  }

  public static void main(String[] args) {
    int[] dp = new int[50];
    fibBasic(50, dp);
  }
}
