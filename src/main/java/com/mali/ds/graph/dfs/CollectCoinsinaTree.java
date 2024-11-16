package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* https://leetcode.com/problems/collect-coins-in-a-tree/description/ */
public class CollectCoinsinaTree {

  public static int collectTheCoins(int[] coins, int[][] edges) {
    int total = coins.length;
    List<Integer>[] graph = new ArrayList[total];
    for (int i = 0; i < total; i++) {
      graph[i] = new ArrayList<>();
    }

    int[] deg = new int[total];
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
      deg[edge[0]]++;
      deg[edge[1]]++;
    }

    // trim edges
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < total; i++) {
      if (graph[i].size() == 1 && coins[i] == 0) {
        queue.add(i);
        deg[i] = 0;
      }
    }

    // trim nested edges as well.
    while (!queue.isEmpty()) {
      int edge = queue.poll();
      for (int neighbour : graph[edge]) {
        deg[neighbour]--;
        if (deg[neighbour] == 1 && coins[neighbour] == 0) {
          queue.add(neighbour);
          deg[neighbour] = 0;
        }
      }
    }

    // add edges with coins to queue again;
    queue = new LinkedList<>();
    for (int i = 0; i < total; i++) {
      if (deg[i] == 1 && coins[i] == 1) {
        queue.add(i);
        deg[i] = 0;
      }
    }

    // now add the distance of each edge
    int[] dis = new int[total];
    while (!queue.isEmpty()) {
      int edge = queue.poll();
      for (int neighbour : graph[edge]) {
        if (deg[neighbour] > 0) {
          deg[neighbour]--;
          dis[neighbour] = Math.max(dis[edge] + 1, dis[neighbour]);
          if (deg[neighbour] == 1) {
            queue.add(neighbour);
            deg[neighbour] = 0;
          }
        }
      }
    }

    int ans = 0;
    for (int d : dis) {
      if (d >= 2) ans += 2;
    }

    return Math.max(0, ans - 2);
  }

  public static void main(String[] args) {
    int[] coins = {0, 0, 0, 1, 1, 0, 0, 1};
    int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {5, 6}, {5, 7}};
    collectTheCoins(coins, edges);
  }

  static void mergeCoins(int[] target, int[] src) {
    target[1] = src[0];
    target[2] = src[1];
    target[3] = src[2] + src[3];
  }

  static void countCoins(int[] indexes, int[][] coins, List<Integer>[] graph, int src) {
    int sum = 0;
    for (int i : graph[src]) {
      int k = coins[i][2] + coins[i][3];
      if (k > 0) {
        sum += indexes[i];
      }
    }
    if (sum > 0) {
      indexes[src] = sum + 2;
    }
  }
}
