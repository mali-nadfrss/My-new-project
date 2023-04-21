package com.mali.ds.graph;

/* https://leetcode.com/problems/regions-cut-by-slashes/description/ */
public class RegionsCutBySlashes {

  public static int regionsBySlashes(String[] grid) {

    int n = grid[0].length();
    int[][] graph = new int[grid.length * 3][n * 3];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i].charAt(j) == ' ') continue;
        else if (grid[i].charAt(j) == '/') {
          graph[i*3 + 2][j*3] = -1;
          graph[i*3 + 1][j*3 + 1] = -1;
          graph[i*3][j*3 + 2] = -1;
        } else {
          graph[i*3][j*3] = -1;
          graph[i*3 + 1][j*3 + 1] = -1;
          graph[i*3 + 2][j*3 + 2] = -1;
        }
      }
    }
    int counter = 0;
    for (int i = 0; i < grid.length * 3; i++) {
      for (int j = 0; j < n * 3; j++) {
        if (graph[i][j] != 0) continue;
        dfs(i, j, graph, ++counter);
      }
    }
    return counter;
  }

  static void dfs(int i, int j, int[][] graph, int count) {
    if (i >= graph.length || i < 0 || j < 0 || j >= graph[0].length) return;
    if (graph[i][j] != 0) return;
    graph[i][j] = count;
    dfs(i + 1, j , graph, count);
    dfs(i , j - 1, graph, count);
    dfs(i - 1, j , graph, count);
    dfs(i , j + 1, graph, count);

  }

  public static void main(String[] args) {
    String[] grid = {" /","/ "};
    regionsBySlashes(grid);
  }
}
