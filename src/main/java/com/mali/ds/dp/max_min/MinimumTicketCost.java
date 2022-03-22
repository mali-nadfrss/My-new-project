package com.mali.ds.dp.max_min;

/*
https://leetcode.com/problems/minimum-cost-for-tickets/
Medium
 */
public class MinimumTicketCost {
  static int minCostTickets(int[] days, int[] costs) {
    int[] dp = new int[366];
    int i = 1;
    for (int j = 0; i < dp.length && j < days.length; i++) {
      int day = dp[i - 1];
      if (days[j] == i) {
        j++;
        day = dp[i - 1] + costs[0];
      }
      int week = i > 7 ? dp[i - 7] + costs[1] : costs[1];
      int month = i > 30 ? dp[i - 30] + costs[2] : costs[2];
      dp[i] = Math.min(day, Math.min(week, month));
    }
    return dp[i - 1];
  }

  public static void main(String[] args) {
    int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
    int[] costs = {2, 7, 15};
    System.out.println(minCostTickets(days, costs));
  }
}
