package com.mali.ds.graph.bfs;

import java.util.*;

/* https://leetcode.com/problems/shortest-path-with-alternating-colors/ */
public class ShortestPathwithAlternatingColors {

  public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

    List<Integer>[] red = new List[n];
    List<Integer>[] blue = new List[n];



    for (int i = 0; i < n; i++) {
      red[i] = new ArrayList<>();
      blue[i] = new ArrayList<>();
    }

    for (int[] edge : redEdges) {
      red[edge[0]].add(edge[1]);
    }

    for (int[] edge : blueEdges) {
      blue[edge[0]].add(edge[1]);
    }

    int[][] ans = new int[2][n];
    Arrays.fill(ans[0], 2 * n);
    Arrays.fill(ans[1], 2 * n);

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {0, 0});
    queue.add(new int[] {0, 1});
    ans[0][0] = 0;
    ans[1][0] = 0;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int prev = cur[0];
      int clr = cur[1];
      if (1 - clr == 0) {
        for (int next : red[prev]) {
          if (ans[1 - clr][next] == 2 * n) {
            queue.add(new int[] {next, 1 - clr});
            ans[1 - clr][next] = 1 + ans[clr][prev];
          }
        }
      } else {
        for (int next : blue[prev]) {
          if (ans[1 - clr][next] == 2 * n) {
            queue.add(new int[] {next, 1 - clr});
            ans[1 - clr][next] = 1 + ans[clr][prev];
          }
        }
      }
    }

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Math.min(ans[0][i], ans[1][i]);
      arr[i] = arr[i] == 2 * n ? -1 : arr[i];
    }

    return arr;
  }

  public static void main(String[] args) {

    int n = 5;
    int[][] redEdges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
    int[][] blueEdges = {{1, 2}, {2, 3}, {3, 1}};
    shortestAlternatingPaths(n, redEdges, blueEdges);
  }
}
