package com.mali.ds.dp;

/*
https://leetcode.com/problems/dungeon-game/
Hard
 */
public class DungeonGame {
  public static int calculateMinimumHP(int[][] dungeon) {

    int rLen = dungeon.length;
    int cLen = dungeon[0].length;
    int[][] dp = new int[rLen][cLen];
    for (int i = rLen - 1; i >= 0; i--) {
      for (int j = cLen - 1; j >= 0; j--) {
        if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
          if (dungeon[i][j] < 0) {
            dp[i][j] = dungeon[i][j];
          }
        } else if (i == dungeon.length - 1) {
          dp[i][j] = Math.min(0, dp[i][j + 1] + dungeon[i][j]);
        } else if (j == dungeon[0].length - 1) {
          dp[i][j] = Math.min(0, dp[i + 1][j] + dungeon[i][j]);
        } else {
          dp[i][j] =
              Math.min(0, Math.max(dungeon[i][j] + dp[i + 1][j], dungeon[i][j] + dp[i][j + 1]));
        }
      }
    }
    return Math.max(-1*dp[0][0]+1, 1);
  }

  public static void main(String[] args) {
    int[][] nums = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
    int[][] nums2 = {{0}};
    System.out.println(calculateMinimumHP(nums));
    System.out.println(calculateMinimumHP(nums2));
  }
}
