package com.mali.ds.dp;

/*
medium
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
*/
public class SellStockWithFee {

  public static int maxProfit(int[] prices, int fee) {
    return recursion(prices, 0, false, fee, new int[prices.length][2]);
  }

  /*
   * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
   * */
  public static int maxProfitWithCoolDown(int[] prices) {
    return recursionCoolDown(prices, 0, false, new int[prices.length][2], false);
  }

  /*
   * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
   * */
  public static int maxProfitWithLimit(int[] prices, int maxLimit) {
    return recursionWithLimit(prices, 0, false, new Integer[prices.length][2][maxLimit], 0, maxLimit);
  }

  static int recursionWithLimit(
      int[] prices, int day, boolean own, Integer[][][] dp, int currentLimit, int maxLimit) {
    if (day == prices.length || currentLimit > maxLimit) return 0;
    if (own) {
      if (dp[day][1][currentLimit] != null) return dp[day][1][currentLimit];
      int p1 = prices[day] + recursionWithLimit(prices, day + 1, false, dp, currentLimit, maxLimit);
      int p2 = recursionWithLimit(prices, day + 1, true, dp, currentLimit, maxLimit);
      dp[day][1][currentLimit] = Integer.max(p1, p2);
      return dp[day][1][currentLimit];
    } else {
      if (dp[day][0][currentLimit] != null) return dp[day][0][currentLimit];
      int p1 = -prices[day] + recursionWithLimit(prices, day + 1, true, dp, currentLimit + 1, maxLimit);
      int p2 = recursionWithLimit(prices, day + 1, false, dp, currentLimit, maxLimit);
      dp[day][0][currentLimit] = Integer.max(p1, p2);
      return dp[day][0][currentLimit];
    }
  }

  static int recursionCoolDown(
      int[] prices, int day, boolean own, int[][] dp, boolean coolDownNeeded) {
    if (day == prices.length) return 0;
    if (own) {
      if (dp[day][1] > 0) return dp[day][1];
      int p1 = prices[day] + recursionCoolDown(prices, day + 1, false, dp, true);
      int p2 = recursionCoolDown(prices, day + 1, true, dp, false);
      dp[day][1] = Integer.max(p1, p2);
      return dp[day][1];
    } else {
      if (dp[day][0] > 0) return dp[day][0];
      int p1 = 0;
      if (!coolDownNeeded) {
        p1 = -prices[day] + recursionCoolDown(prices, day + 1, true, dp, false);
      }
      int p2 = recursionCoolDown(prices, day + 1, false, dp, false);
      return dp[day][0] = Integer.max(p1, p2);
    }
  }

  static int recursion(int[] prices, int day, boolean own, int fee, int[][] dp) {
    if (day == prices.length) return 0;
    if (own && dp[day][1] > 0) return dp[day][1];
    if (!own && dp[day][0] > 0) return dp[day][0];
    if (own) {
      int p1 = prices[day] - fee + recursion(prices, day + 1, false, fee, dp);
      int p2 = recursion(prices, day + 1, true, fee, dp);
      dp[day][1] = Integer.max(p1, p2);
    } else {
      int p1 = -prices[day] + recursion(prices, day + 1, true, fee, dp);
      int p2 = recursion(prices, day + 1, false, fee, dp);
      dp[day][0] = Integer.max(p1, p2);
    }
    if (own) return dp[day][1];
    return dp[day][0];
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] {1, 3, 7, 5, 10, 3}, 3)); // ans 6
    System.out.println(maxProfitWithCoolDown(new int[] {1, 2, 3, 0, 2})); // ans 3
    System.out.println(maxProfitWithCoolDown(new int[] {2, 1, 4})); // ans 2
    System.out.println(maxProfitWithLimit(new int[] {3, 3, 5, 0, 0, 3, 1, 4}, 2)); // ans 6
    int[] prices =
        new int[] { 5717, 5716, 5715, 5714, 5713, 5712, 5711,
          5710, 5709, 5708, 5707, 5706, 5705, 0
        };
    System.out.println(maxProfitWithLimit(prices, 2)); // ans 19
  }
}
