package com.mali.ds.dp.distinctWays;

/* https://leetcode.com/problems/number-of-great-partitions/description/ */
public class NumberOfGreatPartitions {

  public static int countPartitions(int[] nums, int k) {

    int n = nums.length;
    int[][] dp = new int[n + 1][k + 1];
    int MOD = 1000000007;
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = k; j >= 1; j--) {
        dp[i][j] = dp[i - 1][j];
        if (j >= nums[i - 1]) {
          dp[i][j] = (dp[i][j] + dp[i][j - nums[i - 1]]) % MOD;
        }
      }
    }

    long ans = (long) Math.pow(2, n);

    for (int i = 0; i <= k; i++) {
      ans -= 2 * dp[n][i];
    }

    return (int) (ans + MOD) % MOD;
  }

  static int MOD = 1000000007;

  static int myOwn(int i, int[] nums, int k, int sum1, int[][] dp) {

    if (sum1 >= k) return 0;
    if (i >= nums.length) return 1;
    if (dp[i][sum1] != 0) return dp[i][sum1];
    return dp[i][sum1] =
        (myOwn(i + 1, nums, k, sum1 + nums[i], dp) + myOwn(i + 1, nums, k, sum1, dp)) % MOD;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 4};
    System.out.println(countPartitions(arr, 4));
    System.out.println(
        ((Math.pow(2, arr.length) - (2 * myOwn(0, arr, 61, 0, new int[arr.length][1000])) % MOD)
                + MOD)
            % MOD);
  }
}
