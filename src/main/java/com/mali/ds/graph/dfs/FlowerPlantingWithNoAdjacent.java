package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/flower-planting-with-no-adjacent/ */
public class FlowerPlantingWithNoAdjacent {

  public static int[] gardenNoAdj(int n, int[][] paths) {

    List<Integer>[] graph = new List[n + 1];

    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] road : paths) {
      graph[road[0]].add(road[1]);
      graph[road[1]].add(road[0]);
    }

    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    for (int i = 1; i <= n; i++) {
      if (ans[i-1] == -1) {
        ans[i-1] = 1;
        dfs(i, graph, ans);
      }
    }

    return ans;
  }

  static void dfs(int current, List<Integer>[] graph, int[] ans) {
    int[] flowers = new int[5];
    ans[current-1] = 0;
    for (int child : graph[current]) {
      if (ans[child-1] == -1) {
        dfs(child, graph, ans);
      }
      flowers[ans[child-1]] = 1;
    }
    for (int i = 1; i < flowers.length; i++) {
      if (flowers[i] == 0) {
        ans[current-1] = i;
        break;
      }
    }
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] paths = {{1, 2}, {2, 3}, {3, 1}};
    gardenNoAdj(n, paths);
  }
}
