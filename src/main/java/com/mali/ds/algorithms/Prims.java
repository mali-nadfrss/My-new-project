package com.mali.ds.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/min-cost-to-connect-all-points/solutions/1982860/prim-s-algorithm-easy-explanation/ */
public class Prims {

  // minimum spanning tree
  int mst(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

    int ans = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
    pq.add(new int[] {0, 0});
    int[] vis = new int[V];
    while (!pq.isEmpty()) {
      int[] node = pq.poll();
      ans += node[1];
      vis[node[0]] = 1;
      for (ArrayList<Integer> child : adj.get(node[0])) {
        if (vis[child.get(0)] == 0) {
          pq.add(new int[] {child.get(0), child.get(1)});
        }
      }
    }
    return ans;
  }
}
