package com.mali.ds.graph.dfs;

/* https://leetcode.com/problems/detonate-the-maximum-bombs/description/ */
public class DetonatetheMaximumBombs {

  public static int maximumDetonation(int[][] bombs) {

    int ans = 0;

    for (int i = 0; i < bombs.length; i++) {
      int[] vis = new int[bombs.length];
      count = 0;
      dfs(i, bombs, vis);
      ans = Math.max(ans, count);
    }

    return ans;
  }

  static int count = 0;

  static void dfs(int i, int[][] bombs, int[] vis) {
    count++;
    vis[i] = 1;
    for (int j = 0; j < bombs.length; j++) {
      if (vis[j] == 0 && inRange(bombs[i], bombs[j])) {
        dfs(j, bombs, vis);
      }
    }
  }

  static boolean inRange(int[] a, int[] b) {
    long x = Math.abs(a[0] - b[0]);
    long y = Math.abs(a[1] - b[1]);
    long a2 = a[2];
    return x * x + y * y < a2 * a2;
  }

  public static void main(String[] args) {
    int[][] bombs = {{2, 1, 3}, {6, 1, 4}};
    maximumDetonation(bombs);
  }
}
