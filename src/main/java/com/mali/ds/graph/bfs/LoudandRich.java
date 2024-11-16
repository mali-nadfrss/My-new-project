package com.mali.ds.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/loud-and-rich/ */
public class LoudandRich {

  public static int[] loudAndRich(int[][] richer, int[] quiet) {

    int n = quiet.length;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    int[][] quiter = new int[n][2];
    List<Integer>[] graph = new List[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] rich : richer) {
      graph[rich[1]].add(rich[0]);
    }

    for (int i = 0; i < n; i++) {
      if (ans[i] != -1) continue;
      dfs(ans, graph, quiet, quiter, i);
    }
    return ans;
  }

  static void dfs(int[] ans, List<Integer>[] graph, int[] quite, int[][] quiter, int current) {
    ans[current] = current;
    quiter[current] = new int[] {current, quite[current]};
    for (int node : graph[current]) {
      if (ans[node] == -1) {
        dfs(ans, graph, quite, quiter, node);
      }
      if (quiter[node][1] < quiter[current][1]) {
        ans[current] = ans[node];
        quiter[current] = quiter[node];
      }
    }
  }

  public static void main(String[] args) {
    int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
    int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
    loudAndRich(richer, quiet);
  }
}
