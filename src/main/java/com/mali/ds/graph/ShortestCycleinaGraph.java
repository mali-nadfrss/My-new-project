package com.mali.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/contest/biweekly-contest-101/problems/shortest-cycle-in-a-graph/ */
public class ShortestCycleinaGraph {


  public static int findShortestCycle(int n, int[][] edges) {

    ArrayList<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int[] dis = new int[n];
      Arrays.fill(dis, -1);
      dis[i] = 0;
      Queue<Integer> queue = new LinkedList<>();
      queue.add(i);
      while (!queue.isEmpty()) {
        int cur = queue.poll();
        for (int edge : graph[cur]) {
          if (dis[edge] == -1) {
            dis[edge] = dis[cur] + 1;
            queue.add(edge);
          } else if (dis[cur] <= dis[edge]){
            ans = Math.min(dis[cur] + dis[edge] + 1, ans);
            queue = new LinkedList<>();
            break;
          }
        }
      }
    }
    return ans == Integer.MAX_VALUE ? -1 :ans;
  }

  public static void main(String[] args) {
    int n = 7;
    int[][] edges = {{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}};
    System.out.println(findShortestCycle(n ,edges));
  }
}
