package com.mali.ds.dp;

/*
https://leetcode.com/problems/last-stone-weight-ii/
Medium
 */
public class LastStoneWeightII {
  public static int lastStoneWeightII(int[] stones) {
    int total = 0;
    for (int stone : stones) {
      total = total + stone;
    }
    int sum = total / 2;
    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;
    int ans = 0;
    for (int stone : stones) {
      boolean[] temp = dp.clone();
      for (int i = stone; i <= sum; i++) {
        if (dp[i - stone]) {
          temp[i] = true;
          ans = Math.max(i, ans);
          if (ans == sum) return total - 2 * ans;
        }
      }
      dp = temp;
    }
    return total - 2 * ans;
  }

  public static void main(String[] args) {
    System.out.println(lastStoneWeightII(new int[] {31, 26, 33, 21, 40}));
  }
}
