package com.mali.ds.graph.bfs;

import java.util.*;

/* Hard
 * https://leetcode.com/problems/bus-routes/*/
public class BusRoutes {
  public static int numBusesToDestination(int[][] routes, int source, int target) {

      //todo
    Map<Integer, Set<Integer>> stops = new HashMap<>();
    for (int i = 0; i < routes.length; i++) {
      for (int j = 0; j < routes[i].length; j++) {
        stops.computeIfAbsent(routes[i][j], v -> new HashSet<>());
        stops.get(routes[i][j]).add(i);
      }
    }
    int ans = -1;
    Queue<Integer> queue = new LinkedList<>();
    for (int i : stops.get(source)) {
      for (int j = 0; j < routes[i].length; j++) {
        if (routes[i][j] != source) {
          queue.add(routes[i][j]);
        }
        while (!queue.isEmpty()){
         for (int k  : stops.get(queue.poll())) {
            // if (k !)
         }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(numBusesToDestination(new int[][] {{1, 2, 7}, {3, 6, 7}}, 1, 6));
  }
}
