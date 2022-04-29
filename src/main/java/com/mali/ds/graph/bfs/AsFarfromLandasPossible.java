package com.mali.ds.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/as-far-from-land-as-possible/
 * medium */
public class AsFarfromLandasPossible {
  public static int maxDistance(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();
    int ans = -1;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          queue.add(new int[] {i, j});
        }
      }
    }
    if (queue.size() == grid.length * grid[0].length) return -1;
    while (!queue.isEmpty()) {
      int l = queue.size();
      for (int i = 0; i < l; i++) {
        int[] cell = queue.poll();
        for (int[] ints : dir) {
          if (cell[0] + ints[0] >= 0
              && cell[0] + ints[0] < grid.length
              && cell[1] + ints[1] >= 0
              && cell[1] + ints[1] < grid[0].length
              && grid[cell[0] + ints[0]][cell[1] + ints[1]] == 0) {
            queue.add(new int[] {cell[0] + ints[0], cell[1] + ints[1]});
            grid[cell[0] + ints[0]][cell[1] + ints[1]] = 1;
          }
        }
      }
      ans++;
    }

    return ans;
  }

  static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) {
    int[][] days = {
      {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}
    };
    int[][] days2 = {
      {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
      {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
      {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
      {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
      {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
      {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
      {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
      {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
      {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
    };
    System.out.println(maxDistance(days));
    System.out.println(maxDistance(days2));
  }
}
