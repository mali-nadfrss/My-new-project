package com.mali.ds.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/max-area-of-island/
 * medium */
public class MaxAreaofIsland {

  static int[][] dir = {
    {1, 0}, {-1, 0}, {0, 1}, {0, -1},
  };

  public static int maxAreaOfIsland(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    boolean[][] visited = new boolean[n][m];
    Queue<int[]> q = new LinkedList<>();
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int temp = 0;
        if (grid[i][j] == 1 && !visited[i][j]) {
          q.add(new int[] {i, j});
          visited[i][j] = true;
          temp += 1;
        }
        while (!q.isEmpty()) {
          int[] t = q.poll();
          for (int k = 0; k < 4; k++) {
            if (t[0] + dir[k][0] >= 0
                && t[0] + dir[k][0] < n
                && t[1] + dir[k][1] >= 0
                && t[1] + dir[k][1] < m
                && grid[t[0] + dir[k][0]][t[1] + dir[k][1]] == 1
                && !visited[t[0] + dir[k][0]][t[1] + dir[k][1]]) {
              temp += 1;
              q.add(new int[] {t[0] + dir[k][0], t[1] + dir[k][1]});
              visited[t[0] + dir[k][0]][t[1] + dir[k][1]] = true;
            }
          }
        }
        ans = Integer.max(ans, temp);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] q = {
      {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
    System.out.println(maxAreaOfIsland(q));
  }
}
