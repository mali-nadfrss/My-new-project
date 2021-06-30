package com.mali.ds.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/map-of-highest-peak
Medium
*/
public class MapOfHighestPeak {
  static final int[][] DIRECTION = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public static int[][] highestPeak(int[][] isWater) {
    int[][] dp = new int[isWater.length][isWater[0].length];
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (isWater[i][j] == 1) {
          dp[i][j] = 0;
          q.add(new int[] {i, j});
        } else {
          dp[i][j] = -1;
        }
      }
    }
    bfs(isWater, dp, q);
    return dp;
  }

  static void bfs(int[][] isWater, int[][] dp, Queue<int[]> q) {
    while (!q.isEmpty()) {
      int[] cell = q.poll();
      for (int i = 0; i < 4; i++) {
        int row = cell[0] + DIRECTION[i][0];
        int col = cell[1] + DIRECTION[i][1];
        if (!isInside(row, col, isWater.length, isWater[0].length)) {
          continue;
        }
        if (dp[row][col] != -1) {
          continue;
        }
        q.add(new int[] {row, col});
        dp[row][col] = dp[cell[0]][cell[1]] + 1;
      }
    }
  }

  public static boolean isInside(int row, int col, int rowSize, int colSize) {
    return row >= 0 && row < rowSize && col >= 0 && col < colSize;
  }

  public static void main(String[] args) {
    int[][] days = {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
    int[][] days2 = {{0, 1}, {0, 0}};
    System.out.println(highestPeak(days));
  }
}
