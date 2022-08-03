package com.mali.ds.graph.dfs;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/number-of-islands/
 medium
 */
public class NumberOfIslands {
  static final int[][] DIRECTION = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  /* we can do this with either DFS OR BFS
  however BFS results in time limit as we are going to each island and its adjacent ones again and again.
  instead use DFS so that we will cover all the edges in shorter time. */
  public static int numIslands(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int ans = 0;
    boolean[][] visited = new boolean[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
          dfs(grid, visited, i, j);
          ans++;
        }
        visited[i][j] = true;
      }
    }
    return ans;
  }

  static void bfs(char[][] grid, boolean[][] visited, int a, int b) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {a, b});
    while (!q.isEmpty()) {
      int i = q.peek()[0];
      int j = q.poll()[1];
      visited[i][j] = true;
      for (int k = 0; k < DIRECTION.length; k++) {
        if (isInside(i + DIRECTION[k][0], j + DIRECTION[k][1], grid.length, grid[0].length)
            && grid[i + DIRECTION[k][0]][j + DIRECTION[k][1]] == '1'
            && !visited[i + DIRECTION[k][0]][j + DIRECTION[k][1]]) {
          q.add(new int[] {i + DIRECTION[k][0], j + DIRECTION[k][1]});
        }
      }
    }
  }

  static void dfs(char[][] grid, boolean[][] visited, int a, int b) {
    if (a < 0
        || b < 0
        || a >= grid.length
        || b >= grid[0].length
        || visited[a][b]
        || grid[a][b] == '0') return;
    visited[a][b] = true;
    dfs(grid, visited, a + 1, b);
    dfs(grid, visited, a - 1, b);
    dfs(grid, visited, a, b + 1);
    dfs(grid, visited, a, b - 1);
  }

  public static boolean isInside(int row, int col, int rowSize, int colSize) {
    return row >= 0 && row < rowSize && col >= 0 && col < colSize;
  }

  public static void main(String[] args) {
    char[][] days = {
      {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '1', '1'}
    };
    char[][] days2 = {
      {'1', '1', '1'},
      {'0', '1', '0'},
      {'1', '1', '1'}
    };
    System.out.println(numIslands(days2));
  }
}
