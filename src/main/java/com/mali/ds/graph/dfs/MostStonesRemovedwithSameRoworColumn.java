package com.mali.ds.graph.dfs;

// Most Stones Removed with Same Row or Column
// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
// medium to Hard
public class MostStonesRemovedwithSameRoworColumn {

  public static int removeStones(int[][] stones) {
    int ans = 0;
    boolean[] visited = new boolean[stones.length];
    for (int i = 0; i < stones.length; i++) {
      if (!visited[i]) {
        dfs(visited, stones, i);
        ans++;
      }
    }
    return stones.length - ans;
  }

  static void dfs(boolean[] visited, int[][] stones, int i) {
    visited[i] = true;
    for (int j = 0; j < stones.length; j++) {
      if (!visited[j] && (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])) {
        dfs(visited, stones, j);
      }
    }
  }

  public static void main(String[] args) {
    int[][] days = {{0, 1}, {1, 0}, {1, 1}};
    System.out.println(removeStones(days));
  }
}
