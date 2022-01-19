package com.mali.ds.dp;

public class WinesProfit {

  static int winesProfit(int[] prices, int year) {
    int[][] dp = new int[prices.length][prices.length];
    return dp(prices, 1, 0, prices.length - 1, dp);
  }

  static int dp(int[] prices, int year, int start, int end, int[][] dp) {

    if (start > end) {
      return 0;
    }

    if (dp[start][end] != 0) {
      return dp[start][end];
    }
    int actualYear = year - (end-start+1);
    dp[start][end] =
        Math.max(
            dp(prices, year + 1, start + 1, end, dp) + actualYear * prices[start],
            dp(prices, year + 1, start, end - 1, dp) + actualYear * prices[end]);
    return dp[start][end];
  }

  public static void main(String[] args) {
    int[] change = {2, 3, 5, 1, 4};
    int amount = 5;
    System.out.println(winesProfit(change, amount));
  }
}
