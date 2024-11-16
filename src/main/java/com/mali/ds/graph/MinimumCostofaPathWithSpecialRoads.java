package com.mali.ds.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/* https://leetcode.com/contest/weekly-contest-343/problems/minimum-cost-of-a-path-with-special-roads/ */
public class MinimumCostofaPathWithSpecialRoads {

  public static int minimumCost(int[] start, int[] target, int[][] specialRoads) {

    int ans = Math.abs(target[0] - start[0]) + Math.abs(target[1] - start[1]);

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
    Map<String, Integer> dis = new HashMap<>();
    dis.put(target[0] + "SS" + target[1], ans);
    dis.put(start[0] + "SS" + start[1], 0);
    pq.add(new int[]{target[0], target[1], ans});
    pq.add(new int[] {start[0], start[1], dis.get(start[0] + "SS" + start[1])});
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int x = cur[0];
      int y = cur[1];
      if (x == target[0] && y == target[1]) {
        return Math.min(ans, dis.get(x + "SS" + y));
      }

      for (int[] path : specialRoads) {
        if (Math.abs(path[0]-path[2])+Math.abs(path[1]-path[3]) <= path[4]) continue;
        int currentDis =
            dis.get(x + "SS" + y) + Math.abs(x - path[0]) + Math.abs(y - path[1]) + path[4];
        if (dis.get(path[2] + "SS" + path[3]) == null
            || dis.get(path[2] + "SS" + path[3]) > currentDis) {
          dis.put(path[2] + "SS" + path[3], currentDis);
          pq.add(new int[] {path[2], path[3], dis.get(path[2] + "SS" + path[3])});
        }
      }
      int currentDis = dis.get(x + "SS" + y) + Math.abs(x - target[0]) + Math.abs(y - target[1]);
      if (dis.get(target[0] + "SS" + target[1]) == null
          || dis.get(target[0] + "SS" + target[1]) > currentDis) {
        dis.put(target[0] + "SS" + target[1], currentDis);
        pq.add(new int[] {target[0], target[1], dis.get(target[0] + "SS" + target[1])});
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] start = {1, 1};
    int[] target = {4, 6};
    int[][] specialRoads = {
      {4, 3, 4, 3, 3}, {2, 4, 3, 4, 4}, {4, 6, 1, 3, 5}, {1, 5, 1, 2, 4}, {1, 2, 3, 4, 1}
    };
    minimumCost(start, target, specialRoads);
  }
}
