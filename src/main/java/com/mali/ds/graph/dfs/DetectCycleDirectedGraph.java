package com.mali.ds.graph.dfs;

import java.util.ArrayList;

/* https://www.geeksforgeeks.org/detect-cycle-in-a-graph/ */
public class DetectCycleDirectedGraph {

  // we may visit some nodes again and by that time it might be marked as visited
  // thats why use 1 more visited and mark it as false once you come out
  // 4-> 2-> 3 ->1
  // 5 -> 3
  // 6 -> 3 we will visit 3 again here but its not a cycle
  public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
    int vis[] = new int[N];
    int recStack[] = new int[N];
    for (int i = 0; i < N; i++) {
      if (bfs(vis, recStack, adj, 0)) {
        return true;
      }
    }
    return false;
  }

  static boolean bfs(int[] vis, int[] rec, ArrayList<ArrayList<Integer>> adj, int current) {

    if (rec[current] == 1) return true;
    if (vis[current] == 1) return false;
    vis[current] = 1;
    rec[current] = 1;
    for (int i : adj.get(current)) {
      bfs(vis, rec, adj, i);
    }
    rec[current] = 0;
    return false;
  }

  public static void main(String[] args) {
    int V = 6;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);

    // Vertex - 0
    ArrayList<Integer> neighbors = new ArrayList<Integer>();
    neighbors.add(2);
    graph.add(neighbors);

    // Vertex - 1
    neighbors = new ArrayList<Integer>();
    neighbors.add(2);
    neighbors.add(5);
    graph.add(neighbors);

    // Vertex - 2
    neighbors = new ArrayList<Integer>();
    neighbors.add(3);
    graph.add(neighbors);

    // Vertex - 3
    neighbors = new ArrayList<Integer>();
    neighbors.add(4);
    graph.add(neighbors);

    // Vertex - 4
    neighbors = new ArrayList<Integer>();
    neighbors.add(0);
    neighbors.add(1);
    graph.add(neighbors);

    // Vertex - 5
    neighbors = new ArrayList<Integer>();
    graph.add(neighbors);

    System.out.println(isCyclic(V, graph));
  }
}
