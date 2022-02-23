package com.mali.ds.dp.distinctWays;

/*
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * medium
 * */
public class NumberOfDiceRollsWithTargetSum {

  public static int numRollsToTarget(int n, int k, int target) {
    return recursion(n, k, target, new Integer[n + 1][target + 1]);
  }

  static final int MOD = 1000000007;

  static int recursion(int n, int k, int target, Integer[][] dp) {
    // if target is reached and we have used all dice
    if (target == 0 && n == 0) {
      return 1;
    }
    // either target is crossed or dice are completed
    if (target < 0 || n <= 0) return 0;

    /*  here comes the main part, dp
    how did I come to the intuition of using n and target??
    by checking the sub problems that are repeated
    so , what are those can be understood using below
    let us say we have n = 2 and target = 6 and k = 3
           1       2       3
    *     /|\     /|\    /|\
    *    1 2 3   1 2 3  1 2 3
    *  from above if u see in second line we have repeated problems for n = 2 and target
    */
    if (dp[n][target] != null) return dp[n][target];
    int ans = 0;
    // for each face add all other combinations recursively
    for (int i = 1; i <= k; i++) {
      ans = (ans + recursion(n - 1, k, target - i, dp)) % MOD;
    }
    dp[n][target] = ans % MOD;
    return dp[n][target];
  }

  public static void main(String[] args) {
    System.out.println(numRollsToTarget(30, 30, 500));
  }
}
