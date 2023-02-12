package com.mali.ds.dp.distinctWays;

/*
There are N flowers. Each flower can either be red flower or a white flower. How many
ways are there to arrange them in a line of length N such that there are never more than M
flowers of the same color in a row?
* */
public class NFlowersWithMConsecutive {

  static long findWays(int N, int M) {
    long start = System.currentTimeMillis();
    long[][] dp = new long[N][N];
    long ans = 2*recursion(N, M, 1, 1, dp);

    long end = System.currentTimeMillis();
    System.out.println(end - start);

    return ans;
  }

  static long recursion(int N, int M, int count, int size, long[][] dp) {
    if (size == N) {
      return 1;
    }
    if (dp[size][count] > 0) {
      return dp[size][count];
    }
    if (count == M) {
      dp[size][count] = recursion(N, M, 0, size + 1, dp);
    } else {
      dp[size][count] = recursion(N, M, count + 1, size + 1, dp) + recursion(N, M, 0, size + 1, dp);
    }
    return dp[size][count];
  }

  public static void main(String[] args) {
    System.out.println(findWays(3, 2));
  }
}
