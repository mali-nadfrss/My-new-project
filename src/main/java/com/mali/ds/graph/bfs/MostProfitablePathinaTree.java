package com.mali.ds.graph.bfs;

import java.util.*;

/* https://leetcode.com/problems/most-profitable-path-in-a-tree/description/ */
public class MostProfitablePathinaTree {

  public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
    int n = edges.length + 1;
    List<Integer>[] graph = new List[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }

    int[] d0 = bfs(0, graph, 0);
    int[] db = new int[n];
    Arrays.fill(db, 2 * n);
    dfs(bob, graph, new int[n], 0, db);
    int[] dis = bfs1(0, graph, 0, d0, db, amount);
    for (int i = 1; i < n; i++) {
      if (graph[i].size() == 1) ans = Math.max(dis[i], ans);
    }
    return ans;
  }

  static int ans = Integer.MIN_VALUE;

  static int dfs(int start, List<Integer>[] graph, int[] vis, int dist, int[] db) {

    if (start == 0) {
      return db[start] = dist;
    }
    vis[start] = 1;
    int d = 2 * graph.length;
    for (int child : graph[start]) {
      if (vis[child] == 0) {
        int k = dfs(child, graph, vis, dist + 1, db);
        if (k < d) {
          d = k - 1;
        }
      }
    }
    db[start] = d;
    return d;
  }

  static int[] bfs1(int start, List<Integer>[] graph, int prev, int[] d0, int[] db, int[] amount) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    int[] dist = new int[graph.length];
    int[] vis = new int[graph.length];
    vis[start] = 1;
    dist[start] = amount[start];
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        for (int child : graph[cur]) {
          if (vis[child] == 0) {
            queue.add(child);
            vis[child] = 1;
            if (db[child] == 2 * graph.length || d0[child] < db[child]) {
              dist[child] = dist[cur] + amount[child];
            } else if (d0[child] == db[child]) {
              dist[child] = dist[cur] + amount[child] / 2;
            } else {
              dist[child] = dist[cur];
            }
          }
        }
      }
    }
    return dist;
  }

  static int[] bfs(int start, List<Integer>[] graph, int prev) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    int level = 0;
    int[] dis = new int[graph.length];
    Arrays.fill(dis, -1);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        dis[cur] = level;
        for (int child : graph[cur]) {
          if (dis[child] == -1) {
            queue.add(child);
          }
        }
      }
      level++;
    }
    return dis;
  }

  public static void main(String[] args) {
    int[][] edges = {{0, 1}};
    int bob = 1;
    int[] amount = {-7280, 2350};
    mostProfitablePath(edges, bob, amount);
  }
}
